package com.bravedroid.favoritesdishes.views.activities

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bravedroid.favoritesdishes.R
import com.bravedroid.favoritesdishes.databinding.ActivityAdderUpdaterDishBinding
import com.bravedroid.favoritesdishes.databinding.DialogCustomImageSelectionBinding

class AdderUpdaterDishActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mBinding: ActivityAdderUpdaterDishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAdderUpdaterDishBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setupActionBar()
        mBinding.ivAddDishImage.setOnClickListener(this)
    }

    private fun setupActionBar() {
        setSupportActionBar(mBinding.toolbarAddDishActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mBinding.toolbarAddDishActivity.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.iv_add_dish_image -> {
                    customImageSelectionDialog()
                    return
                }
            }
        }
    }

    private fun customImageSelectionDialog() {
        val dialog = Dialog(this)
        val binding: DialogCustomImageSelectionBinding =
            DialogCustomImageSelectionBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        binding.tvCamera.setOnClickListener {
            Toast.makeText(this, " tvCamera :)", Toast.LENGTH_SHORT).show()
        }

        binding.tvGallery.setOnClickListener {
            Toast.makeText(this, " tvGallery :)", Toast.LENGTH_SHORT).show()
        }
        dialog.show()
    }
}
