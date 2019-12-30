import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImage(icon: String) {
    Glide.with(context).load("https://www.weatherbit.io/static/img/icons/$icon.png").into(this)
}