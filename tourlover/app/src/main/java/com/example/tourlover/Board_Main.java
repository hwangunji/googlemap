package com.example.tourlover;
//동영상의 메인엑티비티에 해당
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Board_Main extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView mMainRecyclerView;

    private MainAdapter mAdapter;
    private List<Board_post> mBoardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board__main);

        //RecyclerView의 id 연결
        mMainRecyclerView = findViewById(R.id.main_recycler_view);

        //이번엔 버튼 연결위에 온클릭
        findViewById(R.id.main_write_button).setOnClickListener(this);

        //db안쓰고 text변수에 직접저장 null은 생성자에 서 생성항것 다 채워주기 위해 작성
        mBoardList = new ArrayList<>();
        /* this.id = id;
        this.title = title;
        this.content = content;
        this.name = name;
        this.like = like;
        this.location = location;*/
        mBoardList.add(new Board_post(null,"안뇽하이루",null,"황운지"));

        mAdapter = new MainAdapter(mBoardList);
        mMainRecyclerView.setAdapter(mAdapter);
    }

   // public void onClick(View view)//뒤로버튼 누르면 액티비티 종료함수
   // {//board__main.xml의 onclick
   //     finish();
  //  }
    @Override
    public void onClick(View v) {
    }

    //듀얼텍스트만들기
    private class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
        private List<Board_post> mBoardList;
        //동영상의 Board=Board_post

        public MainAdapter(List<Board_post> mBoardList){
            this.mBoardList = mBoardList;
        }
        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            Board_post data = mBoardList.get(position);
            holder.mTitleTextview.setText(data.getTitle());
            holder.mNameTextView.setText(data.getName());
        }

        @Override
        public int getItemCount() {
            return mBoardList.size();
        }

        class MainViewHolder extends RecyclerView.ViewHolder{
            //item_main.xml에 존재하는 택스트뷰들의 id와 연결할 변수생성
            private TextView mTitleTextview;//item_main의 제목이 들어갑니다 연결
            private TextView mNameTextView;//item_main의 황운지 연결


            public MainViewHolder(View itemview) {
                super(itemview);

                //item_main.xml에 존재하는 택스트뷰들의 id와 연결할 변수들에 id 연결
                mTitleTextview = itemview.findViewById(R.id.item_title_text);
                mNameTextView = itemview.findViewById(R.id.item_name_text);
            }
        }
    }
}
