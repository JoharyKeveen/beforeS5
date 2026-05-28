<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class GestionProposition extends CI_Controller {
    public function redirect(){
        redirect("Traitement/getobjetprofil?objet=".$this->input->get('objet')."");
    }
    public function setprop(){
        $arr=array();
		$this->load->model('exchange');
        $this->exchange->insert_proposition($this->input->get('objet'),$this->input->get('anah'));
        redirect("Pages/acceuil");
    }
    
}
?>