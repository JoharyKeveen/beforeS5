<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Login extends CI_Controller {

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
		$user=$this->input->post('name');
        $mdp=$this->input->post('mdp');
		$this->load->model('Macceuil');
		$this->load->model('Mlogin');
        if($this->Mlogin->check($user,$mdp)==true)
        {
            //	definition des donnees variables du template
            $data['title']='Takalo';
            $data['description']='Sita fanaovana takalo';
            $data['keywords']='takalo';
            $data['list_objet']=$this->Macceuil->selectAllObjet();
			$data['option']=$this->Macceuil->getCat();

            //	on charge la view qui contient le corps de la page
            $data['contents']='template/acceuil';

            //	on charge la page dans le template
            $this->load->view('template',$data);
        }
        else
        {
            redirect('Welcome');
        }
	}

	public function insert()
	{
		$user=$this->input->post('name');
        $mdp=$this->input->post('mdp');
		$email=$this->input->post('email');	
		$this->load->model('Mlogin');
		$this->Mlogin->inscription($user,$email,$mdp);
		redirect('Welcome');
	}

	public function logout()
	{
		$this->session->unset_userdata('online');
		$this->session->unset_userdata('etat');
		redirect('Login');
	}
}
