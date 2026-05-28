<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Traitement extends CI_Controller {

	/**
	 * Index Page for this controller.
	 *
	 * Maps to the following URL
	 * 		http://example.com/index.php/welcome
	 *	- or -
	 * 		http://example.com/index.php/welcome/index
	 *	- or -
	 * Since this controller is set as the default controller in
	 * config/routes.php, it's displayed at http://example.com/
	 *
	 * So any other public methods not prefixed with an underscore will
	 * map to /index.php/welcome/<method_name>
	 * @see https://codeigniter.com/user_guide/general/urls.html
	 */
	public function index()
	{
		$this->load->view('Profil');	
	}

	public function getProfil() //maka ny any anaty base rehetra
	{
		$id=$this->session->userdata('online');
		$this->load->model('Accesbase');
        $this->load->model('Macceuil');
        //	definition des donnees variables du template
        $data['title']='Takalo';
        $data['description']='Sita fanaovana takalo';
        $data['keywords']='takalo';
        $data['var']=$this->Accesbase->select($id);
        $data['option']=$this->Macceuil->getCat();

        //	on charge la view qui contient le corps de la page
        $data['contents']='template/Profil';

        //	on charge la page dans le template
        $this->load->view('template',$data);
	}
	public function getobjetprofil()
	{
		$id=$this->session->userdata('online');
		$this->load->model('Accesbase');
        $this->load->model('Macceuil');
        //	definition des donnees variables du template
        $data['title']='Takalo';
        $data['description']='Sita fanaovana takalo';
        $data['keywords']='takalo';
        $data['var']=$this->Accesbase->getall();
        $data['option']=$this->Macceuil->getCat();

        //	on charge la view qui contient le corps de la page
        $data['contents']='template/echanger';

        //	on charge la page dans le template
        $this->load->view('template',$data);
	}
	public function delete()
	{
		$id=$this->input->get('id');
		$this->load->model('Accesbase');
		$this->load->model('Macceuil');
		$this->Accesbase->delete($id);
        $this->getProfil();
	}

	public function redirection()  			//Avy any am Profil.php mandefa info any am page update.php 
	{
		$description['var'] = $this->input->get('id');
		$description['var1'] = $this->input->get('titre');
		$description['var2'] = $this->input->get('description');
		$this->load->model('Macceuil');
		$description['option']=$this->Macceuil->getCat();
		$description['title']='Takalo';
        $description['description']='Sita fanaovana takalo';
        $description['keywords']='takalo';
		$description['contents']='template/update';

		$this->load->view('template',$description);
	}
	public function update(){		//avy any amin'ny formulaire update.php 
		$val = array();

		$id=$this->input->get('id');
		$titre=$this->input->get('titre');
		$description= $this->input->get('description');
		$prix = $this->input->get('prix');

		$this->load->model('Accesbase');
		$val['val'] = $this->Accesbase->update($id,$titre,$description,$prix);
		$this->getProfil(); 
	}

	public function redirect(){
		$this->load->view('Insertion');
	}

	public function upload()  //manao insertion miaraka am sary // avy any am Insertion.php
	{
		$categorie = $this->input->get('categorie');
		$id_prop = 1;
		$titre = $this->input->get('titre');
		$descriptions = $this->input->get('description');
		$prix = $this->input->get('prix');
		$_FILES = $this->input->get('FILES');

		$this->load->model('Accesbase');
		$val= $this->Accesbase->makaidcategorie($categorie);
		$this->Accesbase->insert($val, $id_prop, $titre, $descriptions, $prix, $_FILES);
	}

}

?>