package uz.ilhomjon.texttovoise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import uz.ilhomjon.texttovoise1.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var textToSpeech:TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textToSpeech = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {

            // if No error is found then only it will run
            if(it!=TextToSpeech.ERROR){
                // To Choose language of speech
                textToSpeech.setLanguage(Locale.ENGLISH);
            }
        })

        binding.btnText.setOnClickListener {
            textToSpeech.speak(binding.Text.text.toString(), TextToSpeech.QUEUE_FLUSH, null)
        }
    }
}