package com.github.caioreigot

import android.graphics.Color
import android.graphics.Typeface
import android.graphics.Typeface.BOLD
import android.graphics.Typeface.NORMAL
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView
import com.github.caioreigot.model.Email

// Herdando de RecyclerView.Adapter<EmailAdapter.EmailViewHolder>()
class EmailAdapter(val emails: MutableList<Email>) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    // Herdando de RecyclerView.ViewHolder(itemView)
    inner class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtIcon: TextView = itemView.findViewById(R.id.txt_icon)
        private val txtUser: TextView = itemView.findViewById(R.id.txt_user)
        private val txtSubject: TextView = itemView.findViewById(R.id.txt_subject)
        private val txtPreview: TextView = itemView.findViewById(R.id.txt_preview)
        private val txtDate: TextView = itemView.findViewById(R.id.txt_date)
        private val imgStar: ImageView = itemView.findViewById(R.id.img_star)

        fun bind(email: Email) {
            //with (email) {}
            val hash = email.user.hashCode()

            txtIcon.text = email.user.first().toString()
            txtIcon.background = itemView.oval(Color.rgb(hash, hash / 2, 0))
            txtUser.text = email.user
            txtSubject.text = email.subject
            txtPreview.text = email.preview
            txtDate.text = email.date

            txtUser.setTypeface(Typeface.DEFAULT, if (email.unread) BOLD else NORMAL)
            txtSubject.setTypeface(Typeface.DEFAULT, if (email.unread) BOLD else NORMAL)
            txtDate.setTypeface(Typeface.DEFAULT, if (email.unread) BOLD else NORMAL)

            imgStar.setImageResource(
                if (email.stared) R.drawable.ic_baseline_star_24
                else R.drawable.ic_baseline_star_border_24
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_item, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.bind(emails[position])
    }

    override fun getItemCount(): Int {
        return emails.size
    }

}

fun View.oval(@ColorInt color: Int): ShapeDrawable {
    val oval = ShapeDrawable(OvalShape())

    //with(oval) {}
    oval.intrinsicHeight = height
    oval.intrinsicWidth = width
    oval.paint.color = color

    return oval
}