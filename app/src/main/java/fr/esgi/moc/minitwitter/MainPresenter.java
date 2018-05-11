package fr.esgi.moc.minitwitter;


/**
 * Created by caroline on 10/05/2018.
 */

public class MainPresenter {

    private String token;
    private MainActivity mainActivity;
    private static final String TAG = "MainPresenter";

    public MainPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
}
