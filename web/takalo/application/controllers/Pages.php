<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Pages extends CI_Controller {

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
	public function acceuil()
	{
        $this->load->model('Macceuil');
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

	public function demande()
	{
        $this->load->model('Mdemande');
        $this->load->model('Macceuil');
        //	definition des donnees variables du template
        $data['title']='Takalo';
        $data['description']='Sita fanaovana takalo';
        $data['keywords']='takalo';
        $data['list_demande']=$this->Mdemande->selectAllDemande();
        $data['option']=$this->Macceuil->getCat();
        //	on charge la view qui contient le corps de la page
        $data['contents']='template/demande';

        //	on charge la page dans le template
        $this->load->view('template',$data);
	}

    public function history()
	{
        $this->load->model('Mhistorique');
        $this->load->model('Macceuil');
        //	definition des donnees variables du template
        $data['title']='Takalo';
        $data['description']='Sita fanaovana takalo';
        $data['keywords']='takalo';
        $data['list_demande']=$this->Mhistorique->selectAllHistory();
        $data['option']=$this->Macceuil->getCat();
        //	on charge la view qui contient le corps de la page
        $data['contents']='template/historique';

        //	on charge la page dans le template
        $this->load->view('template',$data);
	}

    public function admin()
	{
        $this->load->model('Madmin');
        $this->load->model('Macceuil');
		$this->load->model('Detail');
        //	definition des donnees variables du template
        $data['title']='Takalo';
        $data['description']='Sita fanaovana takalo';
        $data['keywords']='takalo';
        $data['list_user']=$this->Madmin->selectAllUser();
        $data['nb_histo']=$this->Madmin->countTransaction();
        $data['option']=$this->Macceuil->getCat();
        $data['nom']=$this->Detail->get_cat();

        //	on charge la view qui contient le corps de la page
        $data['contents']='template/admin';

        //	on charge la page dans le template
        $this->load->view('template',$data);
	}

    public function recherche()
    {
        $this->load->model('Mrecherche');
        $this->load->model('Macceuil');
        $char=$this->input->post('search');
        $option=$this->input->post('select');
        //	definition des donnees variables du template
        $data['title']='Takalo';
        $data['description']='Sita fanaovana takalo';
        $data['keywords']='takalo';
        $data['list']=$this->Mrecherche->search($char,$option);
        $data['option']=$this->Macceuil->getCat();

        //	on charge la view qui contient le corps de la page
        $data['contents']='template/recherche';

        //	on charge la page dans le template
        $this->load->view('template',$data);   
    }

    public function refusDemande()
    {
        $this->load->model('Mdemande');
        $id=$this->input->post('id');
        $this->Mdemande->refus($id);
        $this->load->model('Macceuil');
        //	definition des donnees variables du template
        $data['title']='Takalo';
        $data['description']='Sita fanaovana takalo';
        $data['keywords']='takalo';
        $data['list_demande']=$this->Mdemande->selectAllDemande();
        $data['option']=$this->Macceuil->getCat();

        //	on charge la view qui contient le corps de la page
        $data['contents']='template/demande';

        //	on charge la page dans le template
        $this->load->view('template',$data);
    }

    public function acceptDemande()
    {
        $this->load->model('Mdemande');
        $this->load->model('Macceuil');
        $id=$this->input->post('id');
        $this->Mdemande->accept($id);
        //	definition des donnees variables du template
        $data['title']='Takalo';
        $data['description']='Sita fanaovana takalo';
        $data['keywords']='takalo';
        $data['list_demande']=$this->Mdemande->selectAllDemande();
        $data['option']=$this->Macceuil->getCat();

        //	on charge la view qui contient le corps de la page
        $data['contents']='template/demande';

        //	on charge la page dans le template
        $this->load->view('template',$data);
    }

	public function inser()
	{
		$this->load->model('Detail');
		$this->Detail->insert_cat($this->input->get('categorie'));	
		$this->admin();
	}

	public function del(){
		$this->load->model('Detail');
		$this->Detail->delete_cat($this->input->get('id'));
		$this->admin();
	}
}
