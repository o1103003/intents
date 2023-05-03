package tw.edu.pu.dmwd.natalie.intents

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import tw.edu.pu.dmwd.natalie.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "子青老師FB", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            var it = Intent(Intent.ACTION_VIEW)

            it.data = Uri.parse("https://www.facebook.com/tcyang1971")

            startActivity(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
        */
        when (item.itemId) {

            R.id.web -> {

                var it = Intent(Intent.ACTION_VIEW)

                it.data = Uri.parse("http://www1.pu.edu.tw/~tcyang")

                startActivity(it)

            }
            R.id.email -> {

                var it = Intent(Intent.ACTION_SENDTO)

                it.data = Uri.parse("mailto:tcyang@gm.pu.edu.tw")

                startActivity(it)

            }
            R.id.search -> {

                var it = Intent(Intent.ACTION_WEB_SEARCH)

                it.putExtra(SearchManager.QUERY, "楊子青")

                startActivity(it)

            }
            R.id.map -> {

                var it = Intent(Intent.ACTION_VIEW)

                it.data = Uri.parse("geo:24.2267756,120.5771591")

                startActivity(it)

            }

        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}