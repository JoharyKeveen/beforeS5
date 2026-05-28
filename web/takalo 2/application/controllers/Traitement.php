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

	public function getall() //maka ny any anaty base rehetra
	{
		$val=array();
		$this->load->model('Accesbase');
		$val['var']=$this->Accesbase->getall();
		$this->load->view('Profil',$val);
	}

	public function getProfile() //maka ny any anaty base rehetra
	{
		$val=array();
		$this->load->model('Accesbase');
		$val['var']=$this->Accesbase->getall();
		$this->load->view('Profil',$val);
	}
	public function getobjetprofil(){
		$val=array();
		$this->load->model('Accesbase');
		$val['var']=$this->Accesbase->getall();
		$this->load->view('Template/echanger',$val);
	}
	public function delete()
	{
		$id=$this->input->get('id');
		$this->load->model('Accesbase');
		$this->Accesbase->delete($id);
		$val['var'] = $this->Accesbase->getall(); //miova le getall
		$this->load->view('Profil', $val);
	}

	public function redirection()  			//Avy any am Profil.php mandefa info any am page update.php 
	{
		$description['var'] = $this->input->get('id');
		$description['var1'] = $this->input->get('titre');
		$description['var2'] = $this->input->get('description');

		$this->load->view('update',$description);
	}

	public function update(){		//avy any amin'ny formulaire update.php 
		$val = array();

		$id=$this->input->get('id');
		$titre=$this->input->get('titre');
		$description= $this->input->get('description');
		$prix = $this->input->get('prix');

		$this->load->model('Accesbase');
		$val['val'] = $this->Accesbase->update($id,$titre,$description,$prix);
		$val['var'] = $this->Accesbase->getall();  //miova le getall
		$this->load->view('Profil', $val);
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