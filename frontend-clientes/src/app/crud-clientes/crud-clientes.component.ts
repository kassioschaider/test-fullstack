import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Cliente } from './model/cliente.model';
import { CrudClientesService } from './crud-clientes.service';
import { ValidateBrService } from 'angular-validate-br';
import { HttpErrorResponse } from '@angular/common/http';
import { Email } from './model/email.model';
import { StatusEnum } from './model/status.enum';
import { EmailsService } from './emails.service';
import { CategoriasService } from './categorias.service';
import { Categoria } from './model/categoria.model';

@Component({
  selector: 'crud-clientes',
  templateUrl: './crud-clientes.component.html',
  styleUrls: ['./crud-clientes.component.css']
})
export class CrudClientesComponent implements OnInit {

  formulario: FormGroup;
  formularioEmail: FormGroup;
  clientes: Cliente[];
  idClienteSelecionadoDelete: number;
  clienteSelecionado: Cliente;
  alerta: string = '';
  showModal: any;
  showModalDelete: any;
  showModalEmail: any;
  person: any = "/assets/person.svg";
  emails: Email[];
  statusAll: any = StatusEnum;
  statusAllString: String[];
  categoriasEmail: Categoria[];

  constructor(
    private clienteService: CrudClientesService,
    private emailService: EmailsService,
    private categoriaService: CategoriasService,
    private formBuilder: FormBuilder,
    private validateBrService: ValidateBrService) {
      this.statusAllString = Object.keys(this.statusAll).filter(k => !isNaN(Number(k)));
    }

  ngOnInit(): void {
    this.carregamentoDosClientes();
    this.formulario = this.formBuilder.group({
      id: [null],
      inscricao: [null, [Validators.required, this.validateBrService.cnpj]],
      nome: [null, [Validators.min(3), Validators.maxLength(50), Validators.required]],
      apelido: [null, [Validators.min(3), Validators.maxLength(20), Validators.required]],
      status: [null, [Validators.required]],
      url: [null],
      emails: [null]
    });

    this.formularioEmail = this.formBuilder.group({
      id: [null],
      idCliente: [null],
      idCategoria: [null],
      nome: [null, [Validators.min(3), Validators.maxLength(50), Validators.required]],
      email: [null, [Validators.email, Validators.required]]
    });
  }

  carregamentoDosClientes() {
    this.clienteService.obterTodos().subscribe(
      dados => { this.clientes = dados })
  }

  onSubmit() {
    if (!this.formulario.value.id) {
      this.onCreate();
    } else {
      this.onUpdate();
    }
  }

  onCreate() {
    this.clienteService
      .cadastrar(this.formulario.value)
      .subscribe(resposta => {
        this.clientes.push(Object.assign({}, <Cliente>resposta));
        alert("Cliente cadastrado com sucesso!");
        this.resetarFormulario();
      }, (err: HttpErrorResponse) => {
        err.error.forEach(e => {
          this.alerta = this.alerta + e.campo + " - " + e.erro + "\n";
        })
        alert(this.alerta);
        this.alerta = '';
      });
  }

  onUpdate() {
    this.clienteService
      .atualizar(this.formulario.value)
      .subscribe(resposta => {
        this.clientes.push(Object.assign({}, <Cliente>resposta));
        this.carregamentoDosClientes();
        alert("Cliente atualizado com sucesso!");
        this.resetarFormulario();
      }, (err: HttpErrorResponse) => {
        err.error.forEach(e => {
          this.alerta = this.alerta + e.campo + " - " + e.erro + "\n";
        })
        alert(this.alerta);
        this.alerta = '';
      });
  }

  onDelete() {
    this.clienteService.excluirPorId(this.idClienteSelecionadoDelete)
      .subscribe();
    this.clientes.splice(this.idClienteSelecionadoDelete);
    alert("Cliente excluído com sucesso!");
    this.carregamentoDosClientes();
    return false;
  }

  abrirModalConfirmacaoExclusao(id: number) {
    this.idClienteSelecionadoDelete = id;
    return true;
  }

  abrirModalComClienteSelecionado(idSelecionado) {

    this.clienteService.obterPorId(idSelecionado).subscribe(
      dados => {
        this.formulario.setValue(dados);
        if(this.formulario.controls.url.value) this.person = this.formulario.controls.url.value;
        if(this.formulario.controls.emails.value) this.emails = this.formulario.controls.emails.value;
      });

    return true;
  }

  abrirModalComEmailSelecionado(idSelecionado) {

    this.emailService.obterPorId(idSelecionado).subscribe(
      dados => {
        this.formularioEmail.setValue(dados);
        this.carregarComboCategorias();
      });

    return true;
  }

  carregarComboCategorias() {
    this.categoriaService.obterTodos()
      .subscribe(dados => {
        this.categoriasEmail = <Categoria[]>dados;
      });
  }

  resetarFormulario() {
    this.formulario.reset();
    this.person = "/assets/person.svg";
    this.emails = [];
  }

  abrirModal() {
    return true;
  }

  fecharModal() {
    this.resetarFormulario();
    return false;
  }

  verificaValidTouched(campo) {
    return !this.formulario.get(campo).valid && this.formulario.get(campo).touched;
  }

}
