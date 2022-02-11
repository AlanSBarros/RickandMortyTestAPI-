package com.example.applicationtesterm.koinmodule

import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import org.koin.dsl.module


val imageUtilsModule = module {

    single<Picasso> { Picasso.get() }


}