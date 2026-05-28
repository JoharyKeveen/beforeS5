<?php 
defined('BASEPATH') OR exit('No direct script access allowed');

class Exchange extends CI_Model{
    public function __construct()
    {
        parent::__construct();
    }
    public function get_prop($id_objet_prop){
    
        $requete=array('id_objet'=>$id_objet_prop);
        $this->db->where($requete);
        $query=$this->db->get('objet');
        $result = $query->result_array();
        foreach ($result as $results){
           
           return $results['id_prop'];
        }
        
    }
    
    public function insert_proposition($id_objet_prop,$id_objet_ech){
        $prop=$this->get_prop($id_objet_prop);
        if($prop!=$this->session->userdata('online')){
        $requete=array('id_objet_prop'=>$id_objet_prop,'id_prop'=>$prop,'id_objet_ech'=>$id_objet_ech,'id_ech'=>$this->session->userdata('online'));
        $this->db->insert('proposition',$requete);
        }
        
    }

}   
?>