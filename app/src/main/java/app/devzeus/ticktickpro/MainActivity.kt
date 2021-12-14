package app.devzeus.ticktickpro

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var tv_yt:TextView
    lateinit var tv_tg:TextView
    lateinit var tv_rp:TextView
    lateinit var tv_dl:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        tv_yt.setOnClickListener {
            Toast.makeText(this@MainActivity, "Remember To Subscribe", Toast.LENGTH_SHORT).show()
            startActivity(yt_url)
        }
        tv_tg.setOnClickListener {
            Toast.makeText(this@MainActivity, "Join the channel for updates", Toast.LENGTH_SHORT).show()
            startActivity(tg_ch)
        }
        tv_dl.setOnClickListener {
            Toast.makeText(this@MainActivity, "Report any issues to me", Toast.LENGTH_SHORT).show()
            startActivity(dl_app)
        }
        tv_rp.setOnClickListener {
            Toast.makeText(this@MainActivity, "Summarize the issue", Toast.LENGTH_SHORT).show()
            startActivity(rp)
        }

    }

    private fun initView() {
        tv_yt = findViewById(R.id.youtube)
        tv_tg = findViewById(R.id.tg_channel)
        tv_rp = findViewById(R.id.bug_report)
        tv_dl = findViewById(R.id.dl_app)
    }

    companion object {
        val yt_url = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCoIH4EUB2V-E2uzouD3ZG2g"))
        val dl_app = Intent(Intent.ACTION_VIEW, Uri.parse("https://ticktick.com/about/download"))
        val tg_ch = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/app_devzeus"))
        val rp = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/devzeus"))
    }
}