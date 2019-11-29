package com.github.sample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var isChanged:Boolean = true
    private var isBgChanged:Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        setListener()
    }

    //初始化
    private fun init(){
        //这里editor 可以不需要findViewById 因为kotlin 帮我们找到了
        // import kotlinx.android.synthetic.main.activity_main.*
        //设置高度
        editor.setEditorHeight(200)
        //设置字体大少
        editor.setEditorFontSize(22)
        //设置字体颜色 红色
        editor.setEditorFontColor(Color.RED)
        //这里设置背景 可以自行设置
        //editor.setEditorBackgroundColor(Color.BLUE);
        //editor.setBackgroundColor(Color.BLUE);
        //editor.setBackgroundResource(R.drawable.bg);
        //editor.setBackground("https://raw.githubusercontent.com/wasabeef/art/master/chip.jpg");
        //设置Padding
        editor.setPadding(10,10,10,10)
        //设置提示语 像editext 的 hint
        editor.setPlaceholder("Insert text here...")
    }

    private fun setListener(){

        editor.setOnTextChangeListener {
            preview.text = it
        }

        action_undo.setOnClickListener(this@MainActivity)
        action_redo.setOnClickListener(this@MainActivity)
        action_bold.setOnClickListener(this@MainActivity)
        action_italic.setOnClickListener(this@MainActivity)
        action_subscript.setOnClickListener(this@MainActivity)
        action_superscript.setOnClickListener(this@MainActivity)
        action_strikethrough.setOnClickListener(this@MainActivity)
        action_underline.setOnClickListener(this@MainActivity)
        action_heading1.setOnClickListener(this@MainActivity)
        action_heading2.setOnClickListener(this@MainActivity)
        action_heading3.setOnClickListener(this@MainActivity)
        action_heading4.setOnClickListener(this@MainActivity)
        action_heading5.setOnClickListener(this@MainActivity)
        action_heading6.setOnClickListener(this@MainActivity)
        action_txt_color.setOnClickListener(this@MainActivity)
        action_bg_color.setOnClickListener(this@MainActivity)
        action_indent.setOnClickListener(this@MainActivity)
        action_outdent.setOnClickListener(this@MainActivity)
        action_align_left.setOnClickListener(this@MainActivity)
        action_align_center.setOnClickListener(this@MainActivity)
        action_align_right.setOnClickListener(this@MainActivity)
        action_blockquote.setOnClickListener(this@MainActivity)
        action_insert_bullets.setOnClickListener(this@MainActivity)
        action_insert_numbers.setOnClickListener(this@MainActivity)
        action_insert_image.setOnClickListener(this@MainActivity)
        action_insert_link.setOnClickListener(this@MainActivity)
        action_insert_checkbox.setOnClickListener(this@MainActivity)
        action_insert_video.setOnClickListener(this@MainActivity)
        action_insert_audio.setOnClickListener(this@MainActivity)
    }

    //实现点击方法
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.action_undo ->{
                editor.undo()
            }
            R.id.action_redo ->{
                editor.redo()
            }
            R.id.action_bold ->{
                editor.setBold()
            }
            R.id.action_italic ->{
                editor.setItalic()
            }
            R.id.action_subscript ->{
                editor.setSubscript()
            }
            R.id.action_superscript ->{
                editor.setSuperscript()
            }
            R.id.action_strikethrough ->{
                editor.setStrikeThrough()
            }
            R.id.action_underline ->{
                editor.setUnderline()
            }
            R.id.action_heading1 ->{
                editor.setHeading(1)
            }
            R.id.action_heading2 ->{
                editor.setHeading(2)
            }
            R.id.action_heading3 ->{
                editor.setHeading(3)
            }
            R.id.action_heading4 ->{
                editor.setHeading(4)
            }
            R.id.action_heading5 ->{
                editor.setHeading(5)
            }
            R.id.action_heading6 ->{
                editor.setHeading(6)
            }
            R.id.action_txt_color ->{
                when {
                    isChanged -> editor.setTextColor(Color.BLACK)
                    else -> editor.setTextColor(Color.RED)
                }
                isChanged = !isChanged
            }
            R.id.action_bg_color ->{
                when {
                    isBgChanged -> editor.setTextBackgroundColor(Color.TRANSPARENT)
                    else -> editor.setTextColor(Color.YELLOW)
                }
                isBgChanged = !isBgChanged
            }
            R.id.action_indent ->{
                editor.setIndent()
            }
            R.id.action_outdent ->{
                editor.setOutdent()
            }
            R.id.action_align_left ->{
                editor.setAlignLeft()
            }
            R.id.action_align_center ->{
                editor.setAlignCenter()
            }
            R.id.action_align_right ->{
                editor.setAlignRight()
            }
            R.id.action_blockquote ->{
                editor.setBlockquote()
            }
            R.id.action_insert_bullets ->{
                editor.setBullets()
            }
            R.id.action_insert_numbers ->{
                editor.setNumbers()
            }
            R.id.action_insert_image ->{
                editor.insertImage(
                    "http://image.comapp.fun/Fkfk3ZcAy9iXRVc2WlhxPzz8EviP",
                    "image"
                )
            }
            R.id.action_insert_link ->{
                editor.insertLink("https://github.com/karson0129", "karson")
            }
            R.id.action_insert_checkbox ->{
                editor.insertTodo()
            }
            R.id.action_insert_video ->{
                //第一个参数 是 视频源  第二个参数是 封面图
                editor.insertVideo("http://video.comapp.fun/short_video_20191128001943.mp4", "http://image.comapp.fun/Fkfk3ZcAy9iXRVc2WlhxPzz8EviP")
            }
            R.id.action_insert_audio ->{
                Toast.makeText(this@MainActivity,"待完成",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
