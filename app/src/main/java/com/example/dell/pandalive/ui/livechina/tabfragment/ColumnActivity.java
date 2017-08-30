package com.example.dell.pandalive.ui.livechina.tabfragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.dell.pandalive.R;
import com.example.dell.pandalive.adapter.ColumnCutAdapter;
import com.example.dell.pandalive.adapter.ColumnMoreAdapter;
import com.example.dell.pandalive.app.Myapp;
import com.example.dell.pandalive.base.BaseActivity;
import com.example.dell.pandalive.entity.ChinaBean;
import com.example.dell.pandalive.entity.Point;
import com.example.dell.pandalive.eventbus.ChinaEvent;
import com.example.dell.pandalive.utils.PointEvaluator;
import com.example.dell.pandalive.utils.SpaceItemDecoration;

import org.greenrobot.eventbus.EventBus;

import java.util.Collections;
import java.util.List;

/**
 * Created by dell on 2017/8/29.
 */

public class ColumnActivity extends BaseActivity implements  ColumnCutAdapter.cut_Iface, ColumnMoreAdapter.more_Iface, View.OnClickListener {

    private ImageView column_deleter;
    private Button edit_bt;
    private RelativeLayout cut_re;
    private RecyclerView cut_recycler;
    private TextView more_column;
    private RecyclerView more_recycler;
    private List<ChinaBean.TablistBean> tablist;
    private List<ChinaBean.AlllistBean> alllist;
    private ItemTouchHelper mItemTouchHelper;
    private ColumnCutAdapter cutAdapter;
    private ColumnMoreAdapter moreAdapter;
    private GridLayoutManager gridLayoutManager;
    private RelativeLayout column_ln;
    private ScrollView column_scroll;
    private static boolean cuttouch = true;
    private TextView column_hint;
    private GridLayoutManager morelayout;

    @Override
    protected void initdata() {

        Intent intent = getIntent();
        tablist = (List<ChinaBean.TablistBean>) intent.getExtras().getSerializable("key1");
        alllist = (List<ChinaBean.AlllistBean>) intent.getExtras().getSerializable("key2");

        iscut();

        ismore();

    }

    private void ismore() {

        more_recycler.setHasFixedSize(true);
        morelayout = new GridLayoutManager(this, 3);
        more_recycler.setLayoutManager(morelayout);
        moreAdapter = new ColumnMoreAdapter(Myapp.activity,alllist);
        moreAdapter.getmore(this);
        more_recycler.addItemDecoration(new SpaceItemDecoration(50));
        more_recycler.setAdapter(moreAdapter);

    }

    private void iscut() {

        cut_recycler.setHasFixedSize(true);
        gridLayoutManager = new GridLayoutManager(this, 3);
        cut_recycler.setLayoutManager(gridLayoutManager);
        cutAdapter = new ColumnCutAdapter(Myapp.activity,tablist);
        cutAdapter.getIface(this);
        cut_recycler.addItemDecoration(new SpaceItemDecoration(50));
        cut_recycler.setAdapter(cutAdapter);

        mItemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {

            /**
             * 是否处理滑动事件 以及拖拽和滑动的方向 如果是列表类型的RecyclerView的只存在UP和DOWN，如果是网格类RecyclerView则还应该多有LEFT和RIGHT
             * @param recyclerView
             * @param viewHolder
             * @return
             */
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                    final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                            ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
                    final int swipeFlags = 0;
                    return makeMovementFlags(dragFlags, swipeFlags);
                } else {
                    final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                    final int swipeFlags = 0;
//                    final int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
                    return makeMovementFlags(dragFlags, swipeFlags);
                }
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                //得到当拖拽的viewHolder的Position
                int fromPosition = viewHolder.getAdapterPosition();
                //拿到当前拖拽到的item的viewHolder
                int toPosition = target.getAdapterPosition();
                if (fromPosition < toPosition) {
                    for (int i = fromPosition; i < toPosition; i++) {
                        Collections.swap(tablist, i, i + 1);
                    }
                } else {
                    for (int i = fromPosition; i > toPosition; i--) {
                        Collections.swap(tablist, i, i - 1);
                    }
                }
                cutAdapter.notifyItemMoved(fromPosition, toPosition);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
//                int position = viewHolder.getAdapterPosition();
//                myAdapter.notifyItemRemoved(position);
//                datas.remove(position);
            }

            /**
             * 重写拖拽可用
             * @return
             */
            @Override
            public boolean isLongPressDragEnabled() {
                return false;
            }

            /**
             * 长按选中Item的时候开始调用
             *
             * @param viewHolder
             * @param actionState
             */
            @Override
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                    viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
                }
                super.onSelectedChanged(viewHolder, actionState);
            }

            /**
             * 手指松开的时候还原
             * @param recyclerView
             * @param viewHolder
             */
            @Override
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                viewHolder.itemView.setBackgroundColor(0);
            }
        });

        mItemTouchHelper.attachToRecyclerView(cut_recycler);
    }

    @Override
    protected void initview() {

        column_deleter = (ImageView) findViewById(R.id.column_deleter);
        edit_bt = (Button) findViewById(R.id.edit_bt);
        column_scroll = (ScrollView) findViewById(R.id.column_scroll);
        cut_re = (RelativeLayout) findViewById(R.id.cut_re);
        cut_recycler = (RecyclerView) findViewById(R.id.cut_recycler);
        more_column = (TextView) findViewById(R.id.more_column);
        more_recycler = (RecyclerView) findViewById(R.id.more_recycler);
        column_ln = (RelativeLayout) findViewById(R.id.column_re);
        column_hint = (TextView) findViewById(R.id.column_hint);

        column_deleter.setOnClickListener(this);

        cut_recycler.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return cuttouch;
            }
        });

        edit_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cuttouch) {
                    cuttouch = false;
                    moreAdapter.moretouch = false;
                    column_hint.setVisibility(View.VISIBLE);
                    cutAdapter.imafly = false;
                    edit_bt.setText("完成");
                } else {
                    cuttouch = true;
                    moreAdapter.moretouch = true;
                    column_hint.setVisibility(View.GONE);
                    cutAdapter.imafly = true;
                    edit_bt.setText("编辑");
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            EventBus.getDefault().post(new ChinaEvent(tablist,alllist));
                        }
                    });
                }

                cutAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected int initlayout() {

        setTheme(R.style.Transparent);
        return R.layout.column_activity;
    }

    @Override
    public void LongCheck(RecyclerView.ViewHolder vh) {

        mItemTouchHelper.startDrag(vh);
    }

    @Override
    public void CutonClick(View view, int position) {

        int[] start = new int[2];
        int[] end = new int[2];

        ChinaBean.TablistBean tablistBean = tablist.get(position);
        ChinaBean.AlllistBean alllistBean = new ChinaBean.AlllistBean();
        alllistBean.setTitle(tablistBean.getTitle());
        alllistBean.setUrl(tablistBean.getUrl());
        alllistBean.setOrder(tablistBean.getOrder());
        alllistBean.setType(tablistBean.getType());
        alllist.add(alllistBean);
        moreAdapter.notifyDataSetChanged();
        int last = morelayout.findLastVisibleItemPosition();
        View childAt = more_recycler.getChildAt(last);
        childAt.getLocationOnScreen(end);

        view.getLocationInWindow(start);

        final Button button = new Button(this);
        column_ln.addView(button);
        button.getLayoutParams().width = view.getWidth();
        button.getLayoutParams().height = view.getHeight();
        button.setBackgroundColor(Color.WHITE);
        button.setVisibility(View.VISIBLE);
        button.setText(tablist.get(position).getTitle());
        button.setTextColor(Color.BLACK);
        button.setX(start[0]);
        button.setY(start[1]);

        tablist.remove(tablistBean);
        cutAdapter.notifyDataSetChanged();

        Point point1 = new Point(start[0], start[1]);
        Point point2 = new Point(end[0], end[1]);
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), point1, point2);
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point point = (Point) animation.getAnimatedValue();
                button.setX(point.getX());
                button.setY(point.getY());
            }
        });
        anim.setDuration(500);
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                column_ln.removeView(button);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        anim.start();
    }

    @Override
    public void Onclickmore(View view, final int position) {

        int[] start = new int[2];
        int[] end = new int[2];

        final ChinaBean.AlllistBean alllistBean = alllist.get(position);
        ChinaBean.TablistBean tablistBean = new ChinaBean.TablistBean();
        tablistBean.setTitle(alllistBean.getTitle());
        tablistBean.setUrl(alllistBean.getUrl());
        tablistBean.setOrder(alllistBean.getOrder());
        tablistBean.setType(alllistBean.getType());
        tablist.add(tablistBean);
        cutAdapter.notifyDataSetChanged();
        int last = gridLayoutManager.findLastVisibleItemPosition();
        View childAt = cut_recycler.getChildAt(last);
        childAt.getLocationOnScreen(end);

        view.getLocationInWindow(start);

        final Button button = new Button(this);
        column_ln.addView(button);
        button.getLayoutParams().width = view.getWidth();
        button.getLayoutParams().height = view.getHeight();
        button.setBackgroundColor(Color.WHITE);
        button.setVisibility(View.VISIBLE);
        button.setText(alllist.get(position).getTitle());
        button.setTextColor(Color.BLACK);
        button.setX(start[0]);
        button.setY(start[1]);

        alllist.remove(alllistBean);
        moreAdapter.notifyDataSetChanged();

        Point point1 = new Point(start[0], start[1]);
        Point point2 = new Point(end[0], end[1]);
        ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), point1, point2);
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point point = (Point) animation.getAnimatedValue();
                button.setX(point.getX());
                button.setY(point.getY());
            }
        });
        anim.setDuration(500);
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                column_ln.removeView(button);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        anim.start();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.column_deleter:

                finish();
                break;
        }
    }
}
