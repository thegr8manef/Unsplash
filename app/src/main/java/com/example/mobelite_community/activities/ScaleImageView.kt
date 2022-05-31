package com.example.mobelite_community.activities

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView

/**
 *
 * This view will auto determine the width or height by determining if the
 * height or width is set and scale the other dimension depending on the images dimension
 *
 * This view also contains an ImageChangeListener which calls changed(boolean isEmpty) once a
 * change has been made to the ImageView
 *
 * @author Maurycy Wojtowicz
 */
class ScaleImageView : AppCompatImageView {
    private var imageChangeListener: ImageChangeListener? = null
    private var scaleToWidth =
        false // this flag determines if should measure height manually dependent of width

    constructor(context: Context?) : super(context!!) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context!!, attrs, defStyle
    ) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        init()
    }

    private fun init() {
        this.scaleType = ScaleType.CENTER_INSIDE
    }

    override fun setImageBitmap(bm: Bitmap) {
        super.setImageBitmap(bm)
        if (imageChangeListener != null) imageChangeListener!!.changed(false)
    }

    override fun setImageDrawable(d: Drawable?) {
        super.setImageDrawable(d)
        if (imageChangeListener != null) imageChangeListener!!.changed(d == null)
    }

    override fun setImageResource(id: Int) {
        super.setImageResource(id)
    }

    interface ImageChangeListener {
        // a callback for when a change has been made to this imageView
        fun changed(isEmpty: Boolean)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        var width = MeasureSpec.getSize(widthMeasureSpec)
        var height = MeasureSpec.getSize(heightMeasureSpec)
        /**
         * if both width and height are set scale width first. modify in future if necessary
         */
        scaleToWidth = if (widthMode == MeasureSpec.EXACTLY || widthMode == MeasureSpec.AT_MOST) {
            true
        } else if (heightMode == MeasureSpec.EXACTLY || heightMode == MeasureSpec.AT_MOST) {
            false
        } else throw IllegalStateException("width or height needs to be set to match_parent or a specific dimension")
        if (drawable == null || drawable.intrinsicWidth == 0) {
            // nothing to measure
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            return
        } else {
            if (scaleToWidth) {
                val iw = this.drawable.intrinsicWidth
                val ih = this.drawable.intrinsicHeight
                var heightC = width * ih / iw
                if (height > 0) if (heightC > height) {
                    // dont let hegiht be greater then set max
                    heightC = height
                    width = heightC * iw / ih
                }
                this.scaleType = ScaleType.CENTER_CROP
                setMeasuredDimension(width, heightC)
            } else {
                // need to scale to height instead
                var marg = 0
                if (parent != null) {
                    if (parent.parent != null) {
                        marg += (parent.parent as RelativeLayout).paddingTop
                        marg += (parent.parent as RelativeLayout).paddingBottom
                    }
                }
                val iw = this.drawable.intrinsicWidth
                val ih = this.drawable.intrinsicHeight
                width = height * iw / ih
                height -= marg
                setMeasuredDimension(width, height)
            }
        }
    }
}