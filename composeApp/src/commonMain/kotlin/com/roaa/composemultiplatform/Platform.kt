package com.roaa.composemultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform