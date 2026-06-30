package com.example.konsistdemo

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.Test

class KonsistTest {
  @Test
  fun `production classes reside in the app package`() {
    Konsist
      .scopeFromProduction()
      .classes()
      .assertTrue { it.resideInPackage("com.example.konsistdemo..") }
  }
}
