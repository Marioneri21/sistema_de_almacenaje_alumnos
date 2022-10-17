 package com.example.practica_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica_01.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_view_design.*

 class MainActivity : AppCompatActivity() {
     private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        val data = ArrayList<Alumno>()
        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        //Agregar elementos a la lista
        data.add(
            Alumno(
                "Kevin Piña",
                "20209878",
                "kpina@ucol.mx",
                "https://play-lh.googleusercontent.com/Y_TFr8xFCc_529AJMdpHuxD8zYMzQwXValEXeESS2pmlCNBaMsh1HPU3ZIATD5ljG2w"
            )
        )
        data.add(
            Alumno(
                "Raymundo Montelongo",
                "20172343",
                "rmontelongo19@ucol.mx",
                "https://i.blogs.es/00cef3/pokemon-1-/450_1000.jpeg"
            )
        )
        data.add(
            Alumno(
                "Diego Serratos",
                "20169901",
                "dserratos6@ucol.mx",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSviNEQJyhYHOLf9fMb5xR8Hud4W0xnM1Lfxw&usqp=CAU"
            )
        )
        data.add(
            Alumno(
                "René Valencia",
                "20177013",
                "rvalencia7@ucol.mx",
                "https://as01.epimg.net/diarioas/imagenes/2022/05/29/actualidad/1653826510_995351_1653826595_noticia_normal_recorte1.jpg"
            )
        )
        data.add(
            Alumno(
                "Cesar Araujo",
                "20177789",
                "caraujo@ucol.mx",
                "https://www.purina-latam.com/sites/g/files/auxxlc391/files/purina-brand-que-sabes-de-los-perros-poodle.jpg"
            )
        )
        data.add(
            Alumno(
                "Karina Figueroa",
                "20179090",
                "kgifueroa@ucol.mx",
                "https://s1.eestatic.com/2022/04/05/curiosidades/mascotas/662693868_223268741_1706x960.jpg"
            )
        )
        data.add(
            Alumno(
                "Angel Rojas",
                "20168988",
                "arojas@ucol.mx",
                "https://s1.eestatic.com/2022/04/05/actualidad/662693892_223269482_640x360.jpg"
            )
        )
        data.add(
            Alumno(
                "Mario Neri",
                "20179000",
                "mnrei@ucol.mx",
                "https://s1.eestatic.com/2022/04/05/actualidad/662693902_223269780_640x360.jpg"
            )
        )

        // This will pass the ArrayList to our Adapter
        val adapter = AlumnoAdapter(this, data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        //variable para recibir todos los extras
        val parExtra = intent.extras
        //variables que recibimos todos los extras
        val msje = parExtra?.getString("mensaje")
        val nombre = parExtra?.getString("nombre")
        val cuenta = parExtra?.getString("cuenta")
        val correo = parExtra?.getString("correo")
        val imagen = parExtra?.getString("imagen")
        //Toast.makeText(this,"${nombre}",Toast.LENGTH_LONG).show()
        if(msje=="nuevo"){
            val insertIndex:Int=data.count()
            data.add(insertIndex,
                Alumno(
                    "${nombre}",
                    "${cuenta}",
                    "${correo}",
                    "${imagen}"
                )
            )
            adapter.notifyItemInserted(insertIndex)
        }

        //Click en agregar
        faButton.setOnClickListener{
            val intento2= Intent(this,MainActivityNuevo::class.java)
            //intento2.putExtra("valor1","Hola mundo")
            startActivity(intento2)
        }

    }
}