package com.balivo.floatinglabelsex

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_login.setOnClickListener {
            // Get the email and password
            val email = et_email.text.toString()
            val password = et_password.text.toString()
            if (checkEmail(email) && checkPassword(password)) {

                // Do something here
                Toast.makeText(applicationContext, "Logged-in", Toast.LENGTH_LONG).show()
                Log.d(TAG, "onClick: Credentials are valid")
            } else {
                Log.d(TAG, "onClick: Credentials are invalid")
                Toast.makeText(this@MainActivity,
                        R.string.msg_invalid_creds, Toast.LENGTH_SHORT).show()
            }
        }
    }
    /**
     * Check the email for empty and pattern match
     * @param email
     * @return
     */
    private fun checkEmail(email: String): Boolean {
// check if the email matches the pattern
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        if (TextUtils.isEmpty(email) || !isEmailValid) {
// show error to user
            email_label.error = getString(R.string.err_msg_invalid_email)
            return false
        }
// email is valid, return true
        email_label.isErrorEnabled = false
        return true
    }
    /**
     * Check if the password is empty
     * @param password
     * @return
     */
    private fun checkPassword(password: String): Boolean {
        if (TextUtils.isEmpty(password)) {
// show error to user
            pass_label.error = getString(R.string.err_msg_invalid_pass)
            return false
        }
// password is valid, return true
        pass_label.isErrorEnabled = false
        return true
    }
}