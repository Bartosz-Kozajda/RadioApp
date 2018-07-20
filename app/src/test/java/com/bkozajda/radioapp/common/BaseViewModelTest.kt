package com.bkozajda.radioapp.common

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.rules.TestRule

open class BaseViewModelTest : BaseTest() {
    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()
}