package com.example.neighbors.fragments

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.neighbors.NavigationListener
import com.example.neighbors.R
import com.example.neighbors.data.NeighborRepository
import com.example.neighbors.models.Neighbor
import com.google.android.material.textfield.TextInputLayout


class AddNeighbourFragment : Fragment(){

    private lateinit var click_saveButton: Button
    private lateinit var text_urlImage: EditText
    private lateinit var text_name: EditText
    private lateinit var text_telephone: EditText
    private lateinit var text_webSite: EditText
    private lateinit var text_address: EditText
    private lateinit var text_about: EditText
    //ERRORS
    private lateinit var telephoneLayout: TextInputLayout
    private lateinit var urlImageLayout: TextInputLayout
    private lateinit var urlWebsiteLayout: TextInputLayout



    /**
     * Fonction permettant de définir une vue à attacher à un fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_neighbour_fragment, container, false)

        //
        click_saveButton = view.findViewById(R.id.save_button)
        text_urlImage = view.findViewById(R.id.image)
        text_name = view.findViewById(R.id.name)
        text_telephone = view.findViewById(R.id.telephone)
        text_webSite = view.findViewById(R.id.webSte)
        text_address = view.findViewById(R.id.adress)
        text_about = view.findViewById(R.id.aPropos)

        //errors
        telephoneLayout = view.findViewById(R.id.telLyt)
        urlImageLayout=view.findViewById(R.id.imageLyt)
        urlWebsiteLayout=view.findViewById(R.id.webSiteLyt)

        return view    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? NavigationListener)?.let {
            it.updateTitle(R.string.addNeighbour_fragment)
        }

        //SI TOUS LES CHAMPS NE SONT PAS REMPLIS, AFFICHER UN TOAST
        if (text_about.text.isBlank() || text_address.text.isBlank() || text_webSite.text.isBlank() || text_name.text.isBlank() || text_telephone.text.isBlank() || text_urlImage.text.isBlank() ){
            Toast.makeText(view.context, R.string.toast, Toast.LENGTH_LONG).show()
            click_saveButton.setEnabled(false);

        }
        else{
            click_saveButton.setEnabled(true);

        }

        //lE BOUTON RESTE GRIS TANT QUE TOUS LES CHAMPS NE SONT PAS REMPLIS
        text_urlImage.doAfterTextChanged {
                var verifyUrlImage = Patterns.WEB_URL.matcher(text_urlImage.text).matches()
                if (text_urlImage.text.isBlank( ) || verifyUrlImage==true){
                    urlImageLayout.error = null
                } else {
                    urlImageLayout.error = getString(R.string.error_urlImage)
                }

            if (text_about.text.isBlank() || text_address.text.isBlank() || text_webSite.text.isBlank() || text_name.text.isBlank() || text_telephone.text.isBlank() || text_urlImage.text.isBlank() ){
                click_saveButton.setEnabled(false);
            }
            else{
                click_saveButton.setEnabled(true);
            }
        }
        text_about.doAfterTextChanged {
            if (text_about.text.isBlank() || text_address.text.isBlank() || text_webSite.text.isBlank() || text_name.text.isBlank() || text_telephone.text.isBlank() || text_urlImage.text.isBlank() ){
                click_saveButton.setEnabled(false);
            }
            else{
                click_saveButton.setEnabled(true);
            }
        }
        text_address.doAfterTextChanged {
            if (text_about.text.isBlank() || text_address.text.isBlank() || text_webSite.text.isBlank() || text_name.text.isBlank() || text_telephone.text.isBlank() || text_urlImage.text.isBlank() ){
                click_saveButton.setEnabled(false);
            }
            else{
                click_saveButton.setEnabled(true);
            }
        }
        text_webSite.doAfterTextChanged {
            var verifyUrlWeb = Patterns.WEB_URL.matcher(text_webSite.text).matches()
            if (text_webSite.text.isBlank( ) || verifyUrlWeb == true){
                urlWebsiteLayout.error = null
            } else {
                urlWebsiteLayout.error = getString(R.string.error_urlwebSite)
            }
            if (text_about.text.isBlank() || text_address.text.isBlank() || text_webSite.text.isBlank() || text_name.text.isBlank() || text_telephone.text.isBlank() || text_urlImage.text.isBlank() ){
                click_saveButton.setEnabled(false);
            }
            else{
                click_saveButton.setEnabled(true);
            }
        }
        text_telephone.doAfterTextChanged {
            with(text_telephone.text.toString()) {
                if (isBlank( ) || ((startsWith("06") || startsWith("07")) && length == 10)){
                    telephoneLayout.error = null
                } else {
                    telephoneLayout.error = getString(R.string.error_tel)
                }
            }
            if (text_about.text.isBlank() || text_address.text.isBlank() || text_webSite.text.isBlank() || text_name.text.isBlank() || text_telephone.text.isBlank() || text_urlImage.text.isBlank() ){
                click_saveButton.setEnabled(false);
            }
            else{
                click_saveButton.setEnabled(true);
            }
        }
        text_name.doAfterTextChanged {
            if (text_about.text.isBlank() || text_address.text.isBlank() || text_webSite.text.isBlank() || text_name.text.isBlank() || text_telephone.text.isBlank() || text_urlImage.text.isBlank() ){
                click_saveButton.setEnabled(false);
            }
            else{
                click_saveButton.setEnabled(true);
            }
        }

        click_saveButton.setOnClickListener{

            val urlImage = text_urlImage.text.toString()
            val nameNew=text_name.text.toString()
            val telephoneNew= text_telephone.text.toString()
            val webSiteNew= text_webSite.text.toString()
            val addressNew= text_address.text.toString()
            val aboutNew= text_about.text.toString()

            //URLUtil.isValidUrl()

            val repo = NeighborRepository.getInstance()

            val favorite = true
            val idNew = repo.getNeighbours().size + 1
            val newNeighbor=Neighbor(idNew, nameNew, urlImage, addressNew , telephoneNew, aboutNew, favorite, webSiteNew)


            repo.createNeighbours(newNeighbor)


        }
    }








}