<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Mhistorique extends CI_Model {
    public function __construct()
    {
        parent::__construct();
    }
    public function selectAllHistory()
    {
        $sql="select historique.*,u.username as username,o.titre as sonobjet,ut.username as me,ob.titre as monobjet from historique join utilisateur as u on u.id_utilisateurs=historique.id_prop join utilisateur as ut on ut.id_utilisateurs=historique.id_ech join objet as o on id_objet_prop=o.id_objet join objet as ob on id_objet_ech=ob.id_objet";
        $query=$this->db->query($sql);
        $results = $query->result_array();
        return $results;
    }
}
