<?php 
defined('BASEPATH') OR exit('No direct script acces allowed');

class Accesbase extends CI_Model{
    public function getall(){
         $query = $this->db->query('select o.id_objet,id_prop,titre,descriptions,prix,photo from objet o join photo p on photo=p.photo where o.id_objet=p.id_objet');
         $data=array();
         $result=$query->result_array();
         foreach ($result as $results){
            array_push($data,$results);
         }
         return $data;
    }

    public function select($nb)
    {
        $requete="select o.id_objet,id_prop,titre,descriptions,prix,photo from objet o join photo p on photo=p.photo where o.id_objet=p.id_objet and id_prop=%s ";
        $sql=sprintf($requete,$nb);
        $query=$this->db->query($sql);
        $data = array();
        $result = $query->result_array();
        foreach ($result as $results) {
            array_push($data, $results);
        }
        return $data;
    }

    public function makaidcategorie($categorie){
        $requete = "Select id_categorie from categorie where nom='%s'";
        $sql = sprintf($requete, $categorie);
        $query = $this->db->query($sql);
        $row = $query->row_array();
        return $row['id_categorie'];
    }

    public function delete($idobjet){
        $requete = "delete from objet where id_objet=%s";
        $sql = sprintf($requete, $idobjet);
        $this->db->query($sql);
    }


    public function update($id_objet,$titre, $descriptions, $prix){
        $requete = "update objet set titre='%s', descriptions='%s', prix=%s where id_objet=%s";
        $sql = sprintf($requete, $titre, $descriptions, $prix, $id_objet);
        $this->db->query($sql);
    }
}

?>