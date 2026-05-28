<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Madmin extends CI_Model {
    public function __construct()
    {
        parent::__construct();
    }
    
    public function selectAllUser()
    {
        $sql="select * from utilisateur";
        $query=$this->db->query($sql);
        $results = $query->result_array();
        return $results;
    }

    public function countTransaction()
    {
        $sql="select count(*) as nb from historique";
        $query=$this->db->query($sql);
        $results = $query->result_array();
        return $results[0]['nb'];
    }
}
