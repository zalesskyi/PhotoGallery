package com.zalesskyi.photogallery.utils

import android.animation.Animator

open class SimpleAnimatorListener : Animator.AnimatorListener {

    override fun onAnimationRepeat(animator: Animator?) = Unit

    override fun onAnimationEnd(animator: Animator?) = Unit

    override fun onAnimationCancel(animator: Animator?) = Unit

    override fun onAnimationStart(animator: Animator?) = Unit
}