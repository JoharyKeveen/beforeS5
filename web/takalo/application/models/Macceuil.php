<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Macceuil extends CI_Model {
    public function __construct()
    {
        parent::__construct();
    }
    
    public function selectAllObjet()
    {
        $sentences="select photo.id_objet,id_categorie,id_prop,titre,descriptions,prix,photo from objet join photo on photo.id_objet=objet.id_objet where id_prop!=%s order by objet.id_objet";
        $sql=sprintf($sentences,$this->session->userdata('online'));
        $query=$this->db->query($sql);
        $results = $query->result_array();
        return $results;
    }

    public function getCat()
    {
        $sql="select*from categorie";
        $query=$this->db->query($sql);
        $results = $query->result_array();
        return $results;
    }
}
?>