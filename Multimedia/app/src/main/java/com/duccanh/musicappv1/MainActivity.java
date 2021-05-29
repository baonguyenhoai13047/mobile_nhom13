package com.duccanh.musicappv1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
//import android.app.PendingIntent;


public class MainActivity extends AppCompatActivity {
    public static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1001;
    private static final int NOTIFICATION_ID = 1;
    Uri image_uri;
    ImageView mImageView;

    int current_pos = 0;
    boolean mark_loop = false;
    boolean mark_random = false;
    boolean flag = false;
//    boolean start = true;
    ImageButton btnPlay, btnNext, btnPrevious, btnRandom, btnLoop, btnBack, btn_camera;
    TextView txtTimeStart, txtTimeEnd, txtSingerName, txtSongName;
    SeekBar songBar;
//    ArrayList<Song> listSongs;
    public MediaPlayer mediaPlayer;
    ObjectAnimator animator;
    ImageView imgNHA;
//    imgNHA, imgSoobin, imgAnhQuan, imgGheQua;
//    imgAndre;


    ArrayList<Song> listSongs = new ArrayList<>();
    ListView listView;
//    ImageButton btnPlay, btnPrevious, btnNext, btnRandom, btnLoop, btn_close;

    int pos = 0;

    String[] songs = {
            "Cho lần đi xa",
            "Chẳng có gì đẹp đẽ trên đời mãi",
            "Đêm nay lại mưa rồi em",
            "Mắt biếc",
            "Còn Gì Đau Hơn Chữ Đã Từng",
            "Ghé Qua",
            "Giá Như Phút Chốc Anh Nắm Lấy Em",
            "Luyến",
            "Một Đoạn Bỏ Qua",
            "Nếu Ngày Ấy",
            "Người Từng Thương",
            "Những Ngày Đã Qua",
            "Nỗi Đau Chậm Lại",
            "Tệ Thật Anh Lại Nhớ Em Rồi"};

//    private NotificationManagerCompat notificationManagerCompat;


//    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matchComponents();
        addSongs();
        initSong(current_pos);

//        getAnimation(current_pos);
//        setInVisibility(imgAndre);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, songs);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, songs[position], Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                initSong(pos);
                pos = position;
                btnPlay.setImageResource(R.drawable.pause);
                mediaPlayer.start();
//                Intent intent = new Intent(ListSongActivity.this, MainActivity.class);
                // đưa các giữ liệu vào "thùng chứa" Bundle
//                btnPlay.setImageResource(R.drawable.pause);
//                Bundle bundle = new Bundle();
//                bundle.putInt("BaiHat", pos);
//                bundle.putString("media", mediaPlayer.toString());
//                intent.putExtra("DuLieu", bundle);
//                startActivity(intent);
//                initSong(pos);
//                btnPlay.setImageResource(R.drawable.pause);
//                mediaPlayer.start();

            }
        });

        // Lấy intent của Activity này
//        Intent intent = getIntent();
        // lấy thùng chứa Bundle với tên giao dịch là "GoiTin
//        Bundle bundle = intent.getBundleExtra("DuLieu");
//        if ( bundle != null){
//            pos = bundle.getInt("BaiHat");
//            if (mediaPlayer.isPlaying()){
//                mediaPlayer.stop();
//                btnPlay.setImageResource(R.drawable.pause);
//            }
//                initSong_view(pos);
//                mediaPlayer.start();
//                finish(); // Đóng Activity hiện tại


//            Intent inten = getIntent();
//            Bundle bundle = new Bundle();
//            bundle.putInt("KetQua", 1);
//            intent.putExtra("TapTin", bundle);
//            setResult(resultcode, intent); // phương thức này sẽ trả kết quả cho Activity1



//        };

//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                if (mediaPlayer.isPlaying()){
////                    mediaPlayer.stop();
////                    mediaPlayer.pause();
////                }
//                Intent intent = new Intent(MainActivity.this, ListSongActivity.class);
//                startActivity(intenpackage com.duccanh.musicappv1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
//import android.app.PendingIntent;


public class MainActivity extends AppCompatActivity {
    public static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1001;
    private static final int NOTIFICATION_ID = 1;
    Uri image_uri;
    ImageView mImageView;

    int current_pos = 0;
    boolean mark_loop = false;
    boolean mark_random = false;
    boolean flag = false;
//    boolean start = true;
    ImageButton btnPlay, btnNext, btnPrevious, btnRandom, btnLoop, btnBack, btn_camera;
    TextView txtTimeStart, txtTimeEnd, txtSingerName, txtSongName;
    SeekBar songBar;
//    ArrayList<Song> listSongs;
    public MediaPlayer mediaPlayer;
    ObjectAnimator animator;
    ImageView imgNHA;
//    imgNHA, imgSoobin, imgAnhQuan, imgGheQua;
//    imgAndre;


    ArrayList<Song> listSongs = new ArrayList<>();
    ListView listView;
//    ImageButton btnPlay, btnPrevious, btnNext, btnRandom, btnLoop, btn_close;

    int pos = 0;

    String[] songs = {
            "Cho lần đi xa",
            "Chẳng có gì đẹp đẽ trên đời mãi",
            "Đêm nay lại mưa rồi em",
            "Mắt biếc",
            "Còn Gì Đau Hơn Chữ Đã Từng",
            "Ghé Qua",
            "Giá Như Phút Chốc Anh Nắm Lấy Em",
            "Luyến",
            "Một Đoạn Bỏ Qua",
            "Nếu Ngày Ấy",
            "Người Từng Thương",
            "Những Ngày Đã Qua",
            "Nỗi Đau Chậm Lại",
            "Tệ Thật Anh Lại Nhớ Em Rồi"};

//    private NotificationManagerCompat notificationManagerCompat;


//    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matchComponents();
        addSongs();
        initSong(current_pos);

//        getAnimation(current_pos);
//        setInVisibility(imgAndre);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, songs);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, songs[position], Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                initSong(pos);
                pos = position;
                btnPlay.setImageResource(R.drawable.pause);
                mediaPlayer.start();
//                Intent intent = new Intent(ListSongActivity.this, MainActivity.class);
                // đưa các giữ liệu vào "thùng chứa" Bundle
//                btnPlay.setImageResource(R.drawable.pause);
//                Bundle bundle = new Bundle();
//                bundle.putInt("BaiHat", pos);
//                bundle.putString("media", mediaPlayer.toString());
//                intent.putExtra("DuLieu", bundle);
//                startActivity(intent);
//                initSong(pos);
//                btnPlay.setImageResource(R.drawable.pause);
//                mediaPlayer.start();

            }
        });

        // Lấy intent của Activity này
//        Intent intent = getIntent();
        // lấy thùng chứa Bundle với tên giao dịch là "GoiTin
//        Bundle bundle = intent.getBundleExtra("DuLieu");
//        if ( bundle != null){
//            pos = bundle.getInt("BaiHat");
//            if (mediaPlayer.isPlaying()){
//                mediaPlayer.stop();
//                btnPlay.setImageResource(R.drawable.pause);
//            }
//                initSong_view(pos);
//                mediaPlayer.start();
//                finish(); // Đóng Activity hiện tại


//            Intent inten = getIntent();
//            Bundle bundle = new Bundle();
//            bundle.putInt("KetQua", 1);
//            intent.putExtra("TapTin", bundle);
//            setResult(resultcode, intent); // phương thức này sẽ trả kết quả cho Activity1



//        };

//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                if (mediaPlayer.isPlaying()){
////                    mediaPlayer.stop();
////                    mediaPlayer.pause();
////                }
//                Intent intent = new Intent(MainActivity.this, ListSongActivity.class);
//                startActivity(intent);
//            }
//        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.play);
                    animator.pause();
                }else {
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.pause);
                    getAnimation(current_pos);
                    animator.resume();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_pos++;
                if(current_pos > listSongs.size()-1){
                    current_pos = 0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    animator.pause();
                }
                initSong(current_pos);
                btnPlay.setImageResource(R.drawable.pause);
                mediaPlayer.start();
//                getAnimation(current_pos);
//                animator.resume();
                setTimeTotal();
                updateTime();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_pos--;
                if(current_pos < 0){
                    current_pos = 0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    animator.pause();
                }
                initSong(current_pos);
                btnPlay.setImageResource(R.drawable.pause);
                mediaPlayer.start();
//                getAnimation(current_pos);
//                animator.resume();
                setTimeTotal();
                updateTime();
            }
        });
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.CAMERA) ==
                            PackageManager.PERMISSION_DENIED ||
                            checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                                    PackageManager.PERMISSION_DENIED){
                        String[] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permission, PERMISSION_CODE);
                    }
                    else {
                        openCamera();
                    }
                }
            }
        });
        songBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(songBar.getProgress());
            }
        });

        /*
        * Set SỰ KIỆN LẶP cho bài hát.
        * Ý tưởng: dùng một biến boolean là "mark_loop" để đánh dấu.
        * --> Khởi tạo mark_loop = false.
        * --> Kiểm tra:
        *       +) Nếu mark_loop == false --> set mark_loop == true, set lại image đồng thời
        *          tắt chế độ random bằng cách set mark_random == false nếu nó đang true hoặc
        *          để yên nếu ngược lại.
        *       +) Nếu mark_loop == true --> làm ngược lại.
        * */
        btnLoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mark_loop == false){
                    mark_loop = true;
                    btnLoop.setImageResource(R.drawable.loop_color);
                    if(mark_random == true){
                        mark_random = false;
                        btnRandom.setImageResource(R.drawable.random);
                    }
                } else {
                    mark_loop = false;
                    btnLoop.setImageResource(R.drawable.loop);
                }
            }
        });

        /*
        * Set SỰ KIỆN RANDOM BÀI HÁT.
        * Ý tưởng: dùng biến boolean mark_random để đánh dấu.
        * --> Khởi tạo mark_random == false.
        * --> Nếu mark_random == false --> chuyển sang trạng thái random bằng cách cho mark_random == true.
        *     đồng thời set lại image và tắt chế độ lặp nếu mở.
        * --> Nếu mark_random == false --> thoát chế độ random.
        * */
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mark_random == false){
                    mark_random = true;
                    btnRandom.setImageResource(R.drawable.rand_color);
                    mark_loop = false;
                    btnLoop.setImageResource(R.drawable.loop);
                }else {
                    mark_random = false;
                    btnRandom.setImageResource(R.drawable.random);
                }
            }
        });
    }

    private  void openCamera() {
        if ( flag == false ) {
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.TITLE, "New Picture");
            values.put(MediaStore.Images.Media.DESCRIPTION, "From the camere");
            image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
            startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE);
            flag = true;
        }
        else {
            mImageView.setVisibility(View.GONE);
            flag = false;
        }

    }

    private void sendNotification() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        Notification notification = new Notification.Builder(this)
                .setContentTitle("Title camera")
                .setContentText("Camera hoạt động")
                .setSmallIcon(R.drawable.camera)
                .setLargeIcon(bitmap)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null){

            notificationManager.notify(NOTIFICATION_ID, notification);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERMISSION_CODE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    openCamera();
                }
                else {
                    Toast.makeText(this, "Permission denied...", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            mImageView.setVisibility(View.VISIBLE);
            mImageView.setImageURI(image_uri);
            flag = true;
        }
    }

    public void setInVisibility (ImageView img1){
        img1.setVisibility(View.INVISIBLE);
//        img2.setVisibility(View.INVISIBLE);
//        img3.setVisibility(View.INVISIBLE);
//        img4.setVisibility(View.INVISIBLE);
    }

    public void getAnimation(int p) {
//        String singer = listSongs.get(p).getSinger();
//        if(singer.equals("N.H.A")){
//            animator = ObjectAnimator.ofFloat("rotation", 0, 360);
////            imgNHA.setVisibility(View.VISIBLE);
////            setInVisibility(imgAnhQuan, imgGheQua, imgSoobin);
//        }else if (singer.equals("Anh Quân")){
//            animator = ObjectAnimator.ofFloat(imgAnhQuan, "rotation", 0, 360);
////            imgAnhQuan.setVisibility(View.VISIBLE);
////            setInVisibility(imgNHA, imgSoobin, imgGheQua);
//        }else if (singer.equals("TayNguyen Music")){
//            animator = ObjectAnimator.ofFloat(imgGheQua, "rotation", 0, 360);
////            imgGheQua.setVisibility(View.VISIBLE);
////            setInVisibility(imgNHA, imgAnhQuan, imgSoobin);
//        }else if (singer.equals("Soobin Hoàng Sơn")){
//            animator = ObjectAnimator.ofFloat(imgSoobin, "rotation", 0, 360);
////            imgSoobin.setVisibility(View.VISIBLE);
////            setInVisibility(imgNHA,  imgAnhQuan, imgGheQua);
////        }else if (singer.equals("ENDREA")){
////            animator = ObjectAnimator.ofFloat(imgAndre, "rotation", 0, 360);
////            imgAndre.setVisibility(View.VISIBLE);
////            setInVisibility(imgNHA, imgAnhQuan, imgSoobin, imgGheQua);
//        }
        animator = ObjectAnimator.ofFloat(imgNHA, "rotation", 0, 360);
        animator.setDuration(10000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setRepeatMode(ObjectAnimator.RESTART);
        animator.start();
        animator.pause();
    }

    public void updateTime() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat formatTime = new SimpleDateFormat("mm:ss");

                txtTimeStart.setText(formatTime.format(mediaPlayer.getCurrentPosition()));

                songBar.setProgress(mediaPlayer.getCurrentPosition());

                /* Xử lý các trường hợp khi kết thúc bài hát */
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        /*
                         * Nếu đang ở chế độ lặp lại thì gán current_pos += 0 (giữ nguyên current_pos).
                         * Nếu ko thì tự động chuyển bài bằng cách cho current_pos += 1;
                         * */
                        if (mark_loop == true){
                            current_pos += 0;
                        } else {
                            current_pos += 1;
                            if(current_pos > listSongs.size()-1){
                                current_pos = 0;
                            }
                        }
                        /*
                         * Nếu đang ở chế độ random thì random một bài trong list.
                         * Set bài đó làm bài hát hiện tại.
                         * */
                        if (mark_random == true){
                            int pos = new Random().nextInt(14);
                            current_pos = pos;
                        }

                        animator.pause();
                        initSong(current_pos);
                        btnPlay.setImageResource(R.drawable.pause);
                        mediaPlayer.start();
//                        getAnimation(current_pos);
                        updateTime();
                        animator.resume();
                    }
                });
                handler.postDelayed(this, 500);
            }
        }, 100);
    }

    public void setTimeTotal() {
        SimpleDateFormat formatTime = new SimpleDateFormat("mm:ss");
        txtTimeEnd.setText(formatTime.format(mediaPlayer.getDuration()));
        songBar.setMax(mediaPlayer.getDuration());
    }

    public void initSong(int p){
        mediaPlayer = MediaPlayer.create(this, listSongs.get(p).getFile());
        txtSongName.setText(listSongs.get(p).getName());
        txtSingerName.setText(listSongs.get(p).getSinger());
//        setTimeTotal();
    }
//    public void initSong_view(int p){
//        mediaPlayer = MediaPlayer.create(this, listSongs.get(p).getFile());
//    }

    public void addSongs(){
        listSongs = new ArrayList<>();
        listSongs.add(new Song("Cho Lần Đi Xa", "N.H.A", R.raw.cho_lan_di_xa));
        listSongs.add(new Song("Chẳng Có Gì Đẹp Đẽ Trên Đời", "N.H.A", R.raw.chang_gi_dep_de_tren_doi));
        listSongs.add(new Song("Đêm nay mưa lại rơi", "N.H.A", R.raw.dem_nay_mua_lai_roi));
        listSongs.add(new Song("Mắt Biếc", "N.H.A", R.raw.mat_biec));
        listSongs.add(new Song("Còn Gì Đau Hơn Chữ Đã Từng", "Anh Quân", R.raw.con_gi_dau_hon_chu_da_tung));
        listSongs.add(new Song("Ghé Qua","TayNguyen Music", R.raw.ghe_qua));
        listSongs.add(new Song("Giá Như Phút Chốc Anh Nắm Lấy Em","N.H.A", R.raw.gia_nhu_phut_choc_anh_nam_lay_em));
        listSongs.add(new Song("Luyến","N.H.A", R.raw.luyen));
        listSongs.add(new Song("Một Đoạn Bỏ Qua","N.H.A", R.raw.mot_doan_bo_qua));
        listSongs.add(new Song("Nếu Ngày Ấy","Soobin Hoàng Sơn", R.raw.neu_ngay_ay));
        listSongs.add(new Song("Người Từng Thương","N.H.A", R.raw.nguoi_tung_thuong));
        listSongs.add(new Song("Những Ngày Đã Qua","N.H.A", R.raw.nhung_ngay_da_qua));
        listSongs.add(new Song("Nỗi Đau Chậm Lại","N.H.A", R.raw.noi_dau_cham_lai));
        listSongs.add(new Song("Tệ Thật Anh Lại Nhớ Em Rồi","ENDREA", R.raw.te_that_anh_lai_nho_em));
    }

    public void matchComponents(){
        btnPlay = findViewById(R.id.play);
        btnNext = findViewById(R.id.next);
        btnPrevious = findViewById(R.id.previous);
        btnRandom = findViewById(R.id.random);
        btnLoop = findViewById(R.id.loop);
//        btnBack = findViewById(R.id.btnBack);

        songBar = findViewById(R.id.seekBar);
        txtTimeStart = findViewById(R.id.timeStart);
        txtTimeEnd = findViewById(R.id.timeEnd);
        txtSingerName = findViewById(R.id.singerName);
        txtSongName = findViewById(R.id.songName);

        imgNHA = findViewById(R.id.imgNha);
//        imgSoobin = findViewById(R.id.imgSooBin);
//        imgAndre = findViewById(R.id.imgAndre);
//        imgGheQua = findViewById(R.id.imgGheQua);
//        imgAnhQuan = findViewById(R.id.imgAnhQuan);

        btn_camera = findViewById(R.id.btncamera);
        mImageView = findViewById(R.id.imageView);

        listView = findViewById(R.id.listSongs);
    }
}
