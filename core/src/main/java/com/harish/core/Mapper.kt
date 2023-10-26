package com.harish.core

interface Mapper<F, T> {
    fun mapFrom(from: F): T
}