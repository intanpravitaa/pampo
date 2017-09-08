<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Controll extends CI_Controller {
	
	public function index(){
		$data = array(
			'page' => 'home',
			'link' => 'home'
		);
		
		$this->load->view('template/wrapper', $data);
	}
	
}