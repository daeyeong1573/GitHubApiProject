package org.software.githubapiproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Toast
import androidx.activity.viewModels
import com.example.githubapiproject.R
import com.example.githubapiproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import org.software.githubapiproject.adpater.SearchListAdapter
import org.software.githubapiproject.viewmodel.SearchViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm: SearchViewModel by viewModels()
    private val binding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.vm = vm
        binding.lifecycleOwner = this
        setRecycler()
        searchFn()
    }

    private fun setRecycler(){
        val adapter = SearchListAdapter(vm,this@MainActivity)
        binding.searchRecycler.adapter = adapter
        binding.searchRecycler.setHasFixedSize(true)
    }

    //검색 함수
    fun searchFn(){
        binding.searchEdit.setOnKeyListener { _, keyCode, event ->
            if ((event.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                if (binding.searchEdit.text.toString().isEmpty()) {
                    Toast.makeText(this, "유저를 입력 해주세요.", Toast.LENGTH_SHORT).show()
                    false
                } else {
                    vm.getSearchList(binding.searchEdit.text.toString())
                    true
                }
            } else {
                false
            }
        }
    }

}