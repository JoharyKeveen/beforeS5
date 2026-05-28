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
        if($this->input->post('name')=='root'&&$this->input->post('mdp')=='root')
        {
            $this->session->set_userdata('name',$this->input->post('name'));
            //	definition des donnees variables du template
            $data['title']='Framework';
            $data['description']='Je teste le framework';
            $data['keywords']='frame,work,framework';

            //	on charge la view qui contient le corps de la page
            $data['contents']='template/content';

            //	on charge la page dans le template
            $this->load->view('template',$data);
        }
        else
        {
            redirect('Welcome');
        }
	}
	public function logout()
	{
		$this->session->unset_userdata('name');
		redirect('Login');
	}
}
