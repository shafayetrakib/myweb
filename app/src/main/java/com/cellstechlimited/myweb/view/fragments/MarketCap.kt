package com.cellstechlimited.myweb.view.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.cellstechlimited.myweb.R
import com.cellstechlimited.myweb.databinding.FragmentMarketCapBinding
import com.cellstechlimited.myweb.view.adapter.ImageSliderAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MarketCap : Fragment() {
    private lateinit var binding:FragmentMarketCapBinding

    private lateinit var adapter: ImageSliderAdapter
    private val handler = Handler(Looper.getMainLooper())
    private var currentPage = 0

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentMarketCapBinding.inflate(inflater,container,false)
        val images = listOf(
            R.drawable.pic,
            R.drawable.pic,
            R.drawable.pic
        )

        adapter = ImageSliderAdapter(images)
        binding.viewPager.adapter = adapter

        autoScroll()

        return binding.root
    }
    private fun autoScroll() {
        val runnable = object : Runnable {
            override fun run() {
                if (adapter.itemCount == 0) return
                currentPage = (currentPage + 1) % adapter.itemCount
                binding.viewPager.setCurrentItem(currentPage, true)
                handler.postDelayed(this, 3000) // Auto-scroll delay (3 seconds)
            }
        }
        handler.post(runnable)
    }
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MarketCap.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MarketCap().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}