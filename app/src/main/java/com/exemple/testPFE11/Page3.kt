package com.exemple.testPFE11



import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.FirebaseAuth
import android.annotation.SuppressLint
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.firestore.ktx.firestore
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import java.util.concurrent.TimeUnit

class Page3 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private var db = Firebase.firestore

    private  val firestore = FirebaseFirestore.getInstance()


    val database = FirebaseDatabase.getInstance()
    val reference = database.getReference("chemin/vers/votre/noeud")

    private lateinit var etEmail : TextInputEditText
    private lateinit var NomPrenom : EditText
    private lateinit var DateNaissence : EditText
    private lateinit var LieuNaissence : EditText
    private lateinit var PaysNaissence : EditText
    private lateinit var Nationalite : EditText
    private lateinit var etPassword : TextInputEditText
    private lateinit var pbtsignup : Button
    private lateinit var pbtsignin : TextView
    private lateinit var Masculain : RadioButton
    private lateinit var Feminin : RadioButton
    private lateinit var Celibataire : RadioButton
    private lateinit var Marie : RadioButton
    private lateinit var Divorce : RadioButton
    private lateinit var Veuf : RadioButton
    private lateinit var Profision : EditText
    private lateinit var GroupSex : RadioGroup
    private lateinit var RGSituatoin : RadioGroup
    private lateinit var autre : TextView
    private lateinit var tourisme : CheckBox
    private lateinit var ActivityHumanitair : CheckBox
    private lateinit var Business : CheckBox
    private lateinit var Religion : CheckBox
    private lateinit var RaisonMedicales : CheckBox
    private lateinit var Etude : CheckBox
    private lateinit var Loisire: CheckBox
    private lateinit var Culture : CheckBox
    private lateinit var HotFamille :CheckBox
    private lateinit var HotHotel :CheckBox


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)
        // Initialize Firebase Auth
        auth = Firebase.auth


        HotHotel = findViewById(R.id.Hothotel)
        HotFamille = findViewById(R.id.HotFamille)
        tourisme = findViewById(R.id.ActiviteTourisme)
        ActivityHumanitair = findViewById(R.id.ActiviteHumanitair)
        Business = findViewById(R.id.ActiviteBusiness)
        Religion = findViewById(R.id.ActiviteReligion)
        RaisonMedicales = findViewById(R.id.ActiviteRaisonsMedicale)
        Etude = findViewById(R.id.ActiviteEtude)
        Loisire = findViewById(R.id.ActiviteLoisire)
        Culture = findViewById(R.id.ActiviteCulture)
        etEmail = findViewById(R.id.page3email1)
        NomPrenom = findViewById(R.id.NamePrenom)
        DateNaissence = findViewById(R.id.DateNaissence)
        LieuNaissence = findViewById(R.id.LieuNaissence)
        PaysNaissence = findViewById(R.id.PaysNaissence)
        Nationalite = findViewById(R.id.Nationalite)
        pbtsignin = findViewById(R.id.page3signin)
        pbtsignup = findViewById(R.id.page3signup)
        Feminin  = findViewById(R.id.RadioButtonFeminin)
        Masculain = findViewById(R.id.RadioButtonMasculain)
        Celibataire = findViewById(R.id.RadioButtonCelebataire)
        Marie= findViewById(R.id.RadioButtonMarie)
        Divorce= findViewById(R.id.RadioButtonDivorce)
        Veuf= findViewById(R.id.RadioButtonVeuf)
        Profision= findViewById(R.id. Profision)
        GroupSex = findViewById(R.id.GroupSexe)
        RGSituatoin = findViewById(R.id.RadioGroupSituatoin)
        autre = findViewById(R.id.Autre)



        pbtsignin.setOnClickListener {
            val intent32 = Intent(this,login::class.java)
            startActivity(intent32)
        }

        pbtsignup.setOnClickListener {

                signup()

        }
    }
    /*private fun performSignUpEmail(){
        if (etEmail.text?.isEmpty() == true|| etPassword.text?.isEmpty()== true || NomPrenom.text?.isEmpty()== true ||DateNaissence .text?.isEmpty()== true ||
            LieuNaissence.text?.isEmpty()== true ||  PaysNaissence.text?.isEmpty()== true || Nationalite.text?.isEmpty()== true ){
            Toast.makeText(this,"please fill the fields",Toast.LENGTH_SHORT).show()
            return
        }


        /////// formulaire ardio

        val radioButtonId = GroupSex.checkedRadioButtonId

        if (radioButtonId  == -1) {
            Toast.makeText(this, "sexe non sélectionnée", Toast.LENGTH_SHORT).show()
        } else {
            val radioButton: RadioButton = findViewById(radioButtonId)
            // Stockez la valeur du bouton radio sélectionné dans la base de données
           val selectedValue = radioButton.text.toString()
           val document = collection.document("nom_du_document")
            document.set(mapOf("sexe" to selectedValue))
                .addOnSuccessListener {
                    Toast.makeText(this, " // La valeur du bouton radio a été stockée avec succès dans la base de données", Toast.LENGTH_SHORT).show()

                    // Réalisez les actions supplémentaires si nécessaire
                }
                .addOnFailureListener { exception ->
                    // Une erreur s'est produite lors de la tentative de stockage de la valeur du bouton radio
                    Toast.makeText(this, "sexe non stock", Toast.LENGTH_SHORT).show()

                }
        }




        ////// furm situation
        val radioButtonSituationID = RGSituatoin.checkedRadioButtonId

        if (  radioButtonSituationID == -1) {
            Toast.makeText(this, "Situation non sélectionnée", Toast.LENGTH_SHORT).show()
        } else {
            val radioButton: RadioButton = findViewById(radioButtonSituationID)
            val selectedValuee = radioButton.text.toString()
            val document = collection.document("nom_du_document")
            document.set(mapOf("Situation" to selectedValuee))
                .addOnSuccessListener {
                    Toast.makeText(this, " // La valeur du bouton radio a été stockée avec succès dans la base de données", Toast.LENGTH_SHORT).show()

                    // Réalisez les actions supplémentaires si nécessaire
                }
                .addOnFailureListener { exception ->
                    // Une erreur s'est produite lors de la tentative de stockage de la valeur du bouton radio
                    Toast.makeText(this, "situation non stock", Toast.LENGTH_SHORT).show()

                }

        }
        ////checkbox

        if(tourisme.isChecked == true || ActivityHumanitair.isChecked == true || Business.isChecked == true || Religion.isChecked == true || RaisonMedicales.isChecked == true ||
            Etude.isChecked == true || Loisire.isChecked == true || Culture.isChecked == true || autre.text?.isEmpty() != true) {
        }else{
            Toast.makeText(this, " remplair But de voyage", Toast.LENGTH_SHORT).show()
        }
        if(HotFamille.isChecked == true || HotHotel.isChecked == true){

        }else{
            Toast.makeText(this,"remplair Type de l'hote ",Toast.LENGTH_SHORT).show()
            return
        }
        ////////







        val inputEmail = etEmail.text.toString().trim()
        val inputPassword = etPassword.text.toString().trim()
        val nomprenom = NomPrenom.text.toString().trim()
        val datenaissence = DateNaissence.text.toString().trim()
        val lienaissence = LieuNaissence.text.toString().trim()
        val paysnaissence = PaysNaissence.text.toString().trim()
        val nationalite = Nationalite.text.toString().trim()
        val profision = Profision.text.toString().trim()
        val autre = autre.text.toString().trim()

        auth.createUserWithEmailAndPassword(inputEmail,inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val userMap = hashMapOf(
                        "namePrenom" to  nomprenom,
                        "DateNaissence" to datenaissence,
                        "LieuNaissence" to lienaissence,
                        "PaysNaissence" to paysnaissence,
                        "Nationalite" to nationalite,
                        "But de Voyage" to autre,
                       //   "Sexe" to inputEmail,
                        //"Situation" to inputEmail,
                        "Profision" to profision,
                        //"ButVoyage" to inputEmail,
                        //"TypeHote" to inputEmail,
                        "Email" to inputEmail


                    )
                    val userID = FirebaseAuth.getInstance().currentUser!!.uid
                    db.collection("users").document(userID).set(userMap, SetOptions.merge())
                        .addOnSuccessListener {
                            Toast.makeText(this,"saved to database", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener{
                            Toast.makeText(this,"Failed!", Toast.LENGTH_SHORT).show()
                        }
                    val user = Firebase.auth.currentUser
                    user?.let {
                        val email = it.email
                        val uid = it.uid

                        if ( uid != null){
                            db.collection("users").document(uid).set(userMap)
                                .addOnSuccessListener {

                                    Toast.makeText(this,"saved to database",Toast.LENGTH_SHORT).show()
                                }
                                .addOnFailureListener{
                                    Toast.makeText(this,"Failed!",Toast.LENGTH_SHORT).show()
                                }
                        }else{
                            Toast.makeText(this,"uid is null!!",Toast.LENGTH_SHORT).show()
                        }
                    }
                    val intent3 = Intent(this,MainActivity::class.java)
                    startActivity(intent3)


                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }
            .addOnFailureListener{
                Toast.makeText(this,"error eccurred",Toast.LENGTH_SHORT).show()
            }
    } */

    private fun signup(){
        val uid = FirebaseAuth.getInstance().currentUser!!.uid
        val inputEmail = etEmail.text.toString().trim()
        // val inputPassword = etPassword.text.toString().trim()
        val nomprenom = NomPrenom.text.toString().trim()
        val datenaissence = DateNaissence.text.toString().trim()
        val lienaissence = LieuNaissence.text.toString().trim()
        val paysnaissence = PaysNaissence.text.toString().trim()
        val nationalite = Nationalite.text.toString().trim()
        val profision = Profision.text.toString().trim()
        val autre = autre.text.toString().trim()
        val collection = firestore.collection("users")
        val document = collection.document("$uid")
        ///RadoiGroup
        val radioButtonId = GroupSex.checkedRadioButtonId
        if (radioButtonId != -1) {

        val radioGroupSexe: RadioGroup = findViewById(R.id.GroupSexe)
        val radioGroupSituation: RadioGroup = findViewById(R.id.RadioGroupSituatoin)

        val selectedSexeRadioButtonId = radioGroupSexe.checkedRadioButtonId
        val selectedSituationRadioButtonId = radioGroupSituation.checkedRadioButtonId

        val radioButtonSexe: RadioButton = findViewById(selectedSexeRadioButtonId)
        val selectedSexeValue = radioButtonSexe.text.toString()

        val radioButtonSituation: RadioButton = findViewById(selectedSituationRadioButtonId)
        val selectedSituationValue = radioButtonSituation.text.toString()



        val data = mapOf(
            "sexe" to selectedSexeValue,
            "situation" to selectedSituationValue
        )

        document.set(data)
            .addOnSuccessListener {
                // Succès de l'opération de stockage dans Firebase
                Toast.makeText(this, "Valeurs stockées avec succès dans Firebase", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { exception ->
                // Erreur lors de l'opération de stockage dans Firebase
                Toast.makeText(this, "Erreur lors du stockage dans Firebase", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "Aucun bouton radio n'est sélectionné", Toast.LENGTH_SHORT).show()
        }



        //// CheckBox


        val checkBoxTourisme: CheckBox = findViewById(R.id.ActiviteTourisme)
        val checkBoxHumanitair: CheckBox = findViewById(R.id.ActiviteHumanitair)
        val tourismeSelected = checkBoxTourisme.isChecked
        val humanitaireSelected =checkBoxHumanitair.isChecked

        val checkBoxReligion: CheckBox = findViewById(R.id.ActiviteReligion)
        val checkBoxBusiness: CheckBox = findViewById(R.id.ActiviteBusiness)
        val religionSelected = checkBoxReligion.isChecked
        val businessSelected =checkBoxBusiness.isChecked

        val checkBoRaisonsMedicale: CheckBox = findViewById(R.id.ActiviteRaisonsMedicale)
        val checkBoxActiviteEtude: CheckBox = findViewById(R.id.ActiviteEtude)
        val RaisonsMedicaleSelected = checkBoRaisonsMedicale.isChecked
        val EtudeSelected =checkBoxActiviteEtude.isChecked

        val checkBoxCulture: CheckBox = findViewById(R.id.ActiviteCulture)
        val checkBoxLoisire: CheckBox = findViewById(R.id.ActiviteLoisire)
        val CultureSelected =checkBoxCulture.isChecked
        val LoisireSelected =checkBoxLoisire.isChecked

        val checkBoxHothotel: CheckBox = findViewById(R.id.Hothotel)
        val checkBoxHotFamille: CheckBox = findViewById(R.id.HotFamille)
        val HotFamilleSelected =checkBoxHothotel.isChecked
        val HothotelSelected =checkBoxHotFamille.isChecked

        val dataa = mapOf(
            "RaisonsMedicale" to RaisonsMedicaleSelected,
            "humanitaire" to EtudeSelected,
            "tourisme" to tourismeSelected,
            "humanitaire" to humanitaireSelected,
            "Business" to businessSelected,
            "Religion" to religionSelected,
            "Culture" to CultureSelected,
            "Loisire" to LoisireSelected,
            "HotFamille" to HotFamilleSelected,
            "Hothote" to HothotelSelected

        )
        document.set(dataa)
            .addOnSuccessListener {
                // Succès de l'opération de stockage dans Firebase
                Toast.makeText(this, "Valeurs stockées avec succès dans Firebase", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { exception ->
                // Erreur lors de l'opération de stockage dans Firebase
                Toast.makeText(this, "Butnest pas  stockage dans Firebase", Toast.LENGTH_SHORT).show()
            }
        ///





        ////////





        val userMap = hashMapOf(
            "NOM" to NomPrenom.text.toString().trim(),

        "DateNaissence" to datenaissence,
        "LieuNaissence" to lienaissence,
        "PaysNaissence" to paysnaissence,
        "Nationalite" to nationalite,
        "But de Voyage" to autre,

        //   "Sexe" to inputEmail,
        //"Situation" to inputEmail,
        "Profision" to profision,
        //"ButVoyage" to inputEmail,
        //"TypeHote" to inputEmail,
        "Email" to inputEmail


        )
        db.collection("users").document(uid).set(userMap,SetOptions.merge())
            .addOnSuccessListener {
                Toast.makeText(this,"nom ajouter a la base de donner",Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this,"nooo!!!",Toast.LENGTH_SHORT).show()
            }

    }


}