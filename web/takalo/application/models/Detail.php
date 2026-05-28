<?php 
defined('BASEPATH') OR exit('No direct script access allowed');

class Detail extends CI_Model{
  public function __construct()
  {
      parent::__construct();
  }
public function get_cat()
  { 
    $data=array();
    $query = $this->db->get('categorie');
    $result = $query->result_array();
    foreach ($result as $results){
      array_push($data,$results);
    }
    
    return $data;
  }
public function insert_cat($nom){
    $requete=array('nom'=>$nom);
    $this->db->insert('categorie',$requete);
}
public function delete_cat($id){
    $this->db->delete('categorie', array('id_categorie'=>$id));     
}

}
?>