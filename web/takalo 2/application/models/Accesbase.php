<?php 
defined('BASEPATH') OR exit('No direct script acces allowed');

class Accesbase extends CI_Model{
    public function getall(){
         $query = $this->db->query('Select*from all_element');
         $data=array();
         $result=$query->result_array();
         foreach ($result as $results){
            array_push($data,$results);
         }
         return $data;
    }

    public function select($nb)
    {
        $requete="Select*from all_element where id_prop=%s ";
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

    public function insertphoto($id_objet, $_FILES)
    {
        $nom = $this->upload($_FILES);
        $requete = array('id_objet' => $id_objet, 'photo' => $nom);
        $this->db->insert('photo', $requete);
    }

    public function insert($categorie, $id_prop, $titre, $descriptions, $prix, $_FILES)
    {
        $requete = "insert into objet (id_categorie,id_prop,titre,descriptions,prix) values(%s,%s,'%s','%s',%s)";
        $sql = sprintf($requete, $categorie, $id_prop, $titre, $descriptions, $prix, $_FILES);
        $this->db->query($sql);
        $requete2 = "select max(id_objet)as max from objet";
        $query = $this->db->query($requete2);
        $row= $query->row_array();
        $this->insertphoto($row['max'],$_FILES); 
    }

    public function update($id_objet,$titre, $descriptions, $prix){
        $requete = "update objet set titre='%s', descriptions='%s', prix=%s where id_objet=%s";
        $sql = sprintf($requete, $titre, $descriptions, $prix, $id_objet);
        $this->db->query($sql);
    }

    public function upload($_FILES){
        $files['files'] = $_FILES['files'];        
        $file_count = count($_FILES['files']['name']);
        $img_s;
            for ($i = 0; $i < $file_count; $i++) {
                $filename = $_FILES['files']['name'][$i];
                if (in_array(strchr($filename, "."), array('.png', '.jpg', '.jpeg', '.PNG', '.JPG', '.JPEG'))) {
                    move_uploaded_file($_FILES['files']['tmp_name'][$i], 'assets/images/' . $filename);
                    $img_string .= $filename;

                    if ($i < $file_count - 1) {
                        $img_string .= ",";
                    }
                }
            }
            return $filename;
    }
}

?>