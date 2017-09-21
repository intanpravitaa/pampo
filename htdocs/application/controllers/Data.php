<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Data extends CI_Controller {
	
	public function index(){

		$query = $this->Model->list_data_all("tbl_review")->result_array();

		$data = array(
			'data' => $query,
			'page' => 'ViewData',
			'link' => 'ViewData'
		);
		
		$this->load->view('template/wrapper', $data);
	}

	public function input(){
		$data = array(
			'pic' => null,
			'page' => 'InputData',
			'link' => 'InputData'
		);
		
		$this->load->view('template/wrapper', $data);
	}

	public function proc_input(){
		extract($_GET);
		$alert = "<script>
					alert('Input Success !!');
					window.location.href='".base_url()."index.php/data/input';
					</script>";
		$data_insert = array(
			'judul_review' => $judul,
			'gambar_review' => $pic,
			'deskripsi_review' => $deskripsi,
		);
		$this->Model->simpan_data($data_insert,'tbl_review');

		$data = array(
			'alert' => $alert,
			'page' => 'Notification',
			'link' => 'InputData'
		);
		
		$this->load->view('template/wrapper', $data);
	}

	public function proc_upload_foto(){
		$config['upload_path']          = './gambar_review';
		$config['allowed_types']        = 'gif|jpg|png';
		$config['max_size']             = 2048;
		$config['max_width']            = 2048;
		$config['max_height']           = 2048;
		
		$this->load->library('upload', $config);
		
		if ( !$this->upload->do_upload('userfile'))
		{
			echo "Upload error !!";
		}
		else
		{
			$img = $this->upload->data();
			$gambar = $img['file_name'];
		}
		
		$data = array(
			'pic' => $gambar,
			'page' => 'InputData',
			'link' => 'InputData'
		);
		
		$this->load->view('template/wrapper', $data);
	}

	public function delete_data(){
		extract($_GET);
		
		$query_delete = $this->Model->hapus("id_review",$id,"tbl_review");
		$data = $this->Model->list_data_all("tbl_review")->result_array();
		$data = array(
			'data' => $data,
			'page' => 'ajax_delete',
			'link' => 'ViewData'
		);
		
		$this->load->view('ajax_delete', $data);
	}

	public function edit_data(){
		extract($_GET);
		
		$data = $this->Model->ambil('id_review', $id, 'tbl_review');
		$data = array(
			'data' => $data,
			'page' => 'ajax_edit',
			'link' => 'ViewData'
		);
		
		$this->load->view('ajax_edit', $data);
	}

	public function update(){
		extract($_GET);
		$alert = "<script>
					alert('Update Success !!');
					window.location.href='".base_url()."index.php/data';
					</script>";
		$data_update = array(
			'judul_review' => $judul,
			'deskripsi_review' => $deskripsi,
		);
		$this->Model->update('id_review',$id,'tbl_review',$data_update);

		$data = array(
			'alert' => $alert,
			'page' => 'Notification',
			'link' => 'ViewData'
		);
		
		$this->load->view('template/wrapper', $data);
	}
	
}