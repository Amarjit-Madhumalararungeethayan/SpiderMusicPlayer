package com.example.rhythm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        /**
         *
         * lateinit var items: Array<String>

        override fun onBackPressed() {
        super.onBackPressed()
        System.exit(0)
        }

        lateinit var binding: ActivityHomeBinding

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Permission()

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),0)
        }else{
        player()
        }
        }

        override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
        ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
        player()
        }else{
        Toast.makeText(this,"Permissions not granted", Toast.LENGTH_SHORT).show()
        }
        }

        private fun player() {
        val songs = async{
        val songFinder = MusicFinder(contentResolver)
        songFinder.prepare()
        songFinder.allSongs
        }
        launch{kotlinx.coroutines.exper

        }
        }



        fun gatherSongs(file: File): ArrayList<File> {
        val arrayList = ArrayList<File>()
        val files = file.listFiles()
        for (singleFile in files) {

        if (singleFile.isDirectory && !singleFile.isHidden) {

        arrayList.addAll(gatherSongs(singleFile))
        } else {

        if (singleFile.name.endsWith(".mp3") || singleFile.name.endsWith(".wav")) {

        arrayList.addAll(gatherSongs(singleFile))
        }
        }
        }
        Log.d("❤️", " passed")
        return arrayList
        }

        fun displaySongs(){

        val songList : ArrayList<File> = gatherSongs(Environment.getExternalStorageDirectory())
        //items = String[songList];

        var temp = (songList.size)-1
        for(i in 0..temp){
        items[i] = songList[i].name.toString().replace(".mp3", "").replace(".wav","")

        val myAdapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1,items)
        binding.list.adapter = myAdapter
        }
        }
        }


         */
    }
}