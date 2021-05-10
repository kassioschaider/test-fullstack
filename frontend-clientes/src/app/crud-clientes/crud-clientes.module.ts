import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CrudClientesComponent } from './crud-clientes.component';


@NgModule({
  declarations: [CrudClientesComponent],
  imports: [
    CommonModule, HttpClientModule, FormsModule, ReactiveFormsModule
  ],
  exports: [CrudClientesComponent]
})
export class CrudClientesModule { }
