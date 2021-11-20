package co.edu.eam.mytestapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.NonNull
import co.edu.eam.mytestapp.R
import co.edu.eam.mytestapp.databinding.ActivityForgotPasswordBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class ForgotPassword : AppCompatActivity() {

    lateinit var binding: ActivityForgotPasswordBinding
    lateinit var recuperar:MaterialButton
    lateinit var textEmailAddress: TextInputEditText
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnRecuperar.setOnClickListener{ recuperarContrasena() }
    }

    fun recuperarContrasena(){
        val email = binding.emailUser.text.toString()

        if(email.isNotEmpty()) {
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.v("Send successful", "Email sent.")
                    }
                }
            Toast.makeText(baseContext, "Correo enviado para cambiar la contraseña", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
