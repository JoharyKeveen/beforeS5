<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Mrecherche extends CI_Model {
    public function __construct()
    {
        parent::__construct();
    }
    
    public function search($char,$option)
    {
        if($option>0)
        {
            $sentences="select photo.id_objet,id_categorie,id_prop,titre,descriptions,prix,photo from objet join photo on photo.id_objet=objet.id_objet where INSTR(titre,'%s')>0 and id_categorie=%s";
            $sql=sprintf($sentences,$char,$option);
        }
        else
        {
            $sentences="select photo.id_objet,id_categorie,id_prop,titre,descriptions,prix,photo from objet join photo on photo.id_objet=objet.id_objet where INSTR(titre,'%s')>0";
            $sql=sprintf($sentences,$char);  
        }
        $query=$this->db->query($sql);
        $results = $query->result_array();
        return $results;
    }
}
?>