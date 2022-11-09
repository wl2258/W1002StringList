package kr.ac.kumoh.s20200607.w1002stringlist

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kr.ac.kumoh.s20200607.w1002stringlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var view: ActivityMainBinding

    private val songs = arrayOf (
        "사건의 지평선", "예뻤어", "한 페이지가 될 수 있게", "love me like that", "I loved you",
            )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)

        view.list.adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, songs) //한 줄로 보여줌

        view.list.setOnItemClickListener { _, _, i, _ ->
            val uri = Uri.parse("http://youtube.com/results?search_query=노래방+" + songs[i])
            val youtube = Intent(Intent.ACTION_VIEW, uri)
            startActivity(youtube)

        }
    }
}