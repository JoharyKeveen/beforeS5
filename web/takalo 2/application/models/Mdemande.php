<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Mdemande extends CI_Model {
    public function __construct()
    {
        parent::__construct();
    }
    public function selectAllDemande()
    {
        $sentences="select proposition.*,username,ob.titre as sonobjet,o.titre as monobjet from proposition join utilisateur on utilisateur.id_utilisateurs=proposition.id_ech join objet as o on id_objet_prop=o.id_objet join objet as ob on id_objet_ech=ob.id_objet where o.id_prop=%s";
        $sql=sprintf($sentences,$this->session->userdata('online'));
        $query=$this->db->query($sql);
        $results = $query->result_array();
        return $results;
    }

    public function refus($id)
    {
        $this->db->delete('proposition', array('id'=>$id)); 
    }

    public function accept($id)
    {
        //select proposition
        $array = array('id' => $id);
        $this->db->where($array);
        $query = $this->db->get('proposition');
        $result = $query->result_array();

        //insert historique
        $sentence="insert into historique values(null,%s,%s,%s,%s,now())";
        $sql=sprintf($sentence,$result[0]['id_ech'],$result[0]['id_objet_ech'],$result[0]['id_prop'],$result[0]['id_objet_prop']);
        $this->db->query($sql);    

        //set proprio objet 1
        $this->db->set('id_prop',$result[0]['id_ech']);              
        $this->db->where('id_objet',$result[0]['id_objet_prop']);                       
        $this->db->update('objet'); 

        //set proprio objet 2
        $this->db->set('id_prop',$result[0]['id_prop']);              
        $this->db->where('id_objet',$result[0]['id_objet_ech']);                       
        $this->db->update('objet'); 

        //delete demande
        $this->db->delete('proposition', array('id'=>$id)); 
    }
}
