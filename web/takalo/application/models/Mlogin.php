<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Mlogin extends CI_Model {
    public function __construct()
    {
        parent::__construct();
    }
    public function check($user,$mdp)
    {
        $array = array('username' => $user, 'mdp' => $mdp);
        $this->db->where($array);
        $query = $this->db->get('utilisateur');
        $results = $query->result_array();
        foreach($results as $result)
        {
            $this->session->set_userdata('online',$result['id_utilisateurs']);
            $this->session->set_userdata('etat',$result['etat']);
            return true;
        }
        return false;
    }

    public function inscription($user,$email,$mdp)
    {
        $data = array('username' => $user, 'email' => $email, 'mdp' => $mdp, 'etat' => 0);
        $this->db->insert('utilisateur',$data);
    }

    public function selectAllDemande()
    {
        $sentences="select proposition.*,username,o.titre as sonobjet,ob.titre as monobjet from proposition join utilisateur on utilisateur.id_utilisateurs=proposition.id_prop join objet as o on id_objet_prop=o.id_objet join objet as ob on id_objet_ech=ob.id_objet where id_ech=%s";
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
        $data = array('id_ech' => $result[0]['id_ech'], 'id_objet_ech' => $result[0]['id_objet_ech'], 'id_prop' => $result[0]['id_prop'],'id_objet_prop' => $result[0]['id_objet_prop']);
        $this->db->insert('historique',$data);    

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
