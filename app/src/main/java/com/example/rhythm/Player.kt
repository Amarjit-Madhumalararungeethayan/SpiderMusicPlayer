package com.example.rhythm

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.SeekBar
import com.example.rhythm.databinding.ActivityPlayerBinding

class Player : AppCompatActivity() {
    lateinit var binding: ActivityPlayerBinding

    lateinit var player : MediaPlayer
    var dur : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        player = MediaPlayer.create(this, R.raw.sample)
        player.isLooping = true
        player.setVolume(0.6f, 0.6f)
        dur = player.duration


        binding.play.setOnClickListener() {
            if(player.isPlaying){
                player.pause()
                binding.play.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            }else{
                player.start()
                binding.play.setImageResource(R.drawable.ic_baseline_pause_24)
            }
        }

        // Volume Bar
        binding.vol.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        var volumeNum = progress / 100.0f
                        player.setVolume(volumeNum, volumeNum)
                    }
                }
                override fun onStartTrackingTouch(p0: SeekBar?) {
                }
                override fun onStopTrackingTouch(p0: SeekBar?) {
                }
            }
        )

        // Position Bar
        binding.pos.max = dur
        binding.pos.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        player.seekTo(progress)
                    }
                }
                override fun onStartTrackingTouch(p0: SeekBar?) {
                }
                override fun onStopTrackingTouch(p0: SeekBar?) {
                }
            }
        )

        // Thread
        Thread(Runnable {
            while (player != null) {
                try {
                    var message = Message()
                    message.what = player.currentPosition
                    handler.sendMessage(message)
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                }
            }
        }).start()
    }

    @SuppressLint("HandlerLeak")
    var handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            var currentPosition = msg.what

            // Update positionBar
            binding.pos.progress = currentPosition

            // Update Labels
            var elapsedTime = createTimeLabel(currentPosition)
            binding.st.text = elapsedTime

            var remainingTime = createTimeLabel(dur - currentPosition)
            binding.fi.text = "-$remainingTime"
        }
    }

    fun createTimeLabel(time: Int): String {
        var timeLabel = ""
        var min = time / 1000 / 60
        var sec = time / 1000 % 60

        timeLabel = "$min:"
        if (sec < 10) timeLabel += "0"
        timeLabel += sec

        return timeLabel
    }

    fun playBtnClick(v: View) {

        if (player.isPlaying) {
            // Stop
            player.pause()
            binding.play.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24)

        } else {
            // Start
            player.start()
            binding.play.setBackgroundResource(R.drawable.ic_baseline_pause_24)
        }
    }
}