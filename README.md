# MoneyMinder
Software de controle de gastos. 

## Requisitos

- [ ] CRUD Movimentações
- [ ] CRUD Categorias
- [ ] Dashboard 
- [ ] Autenticação

## Endpoints

### Categorias

`GET` /categoria

Lista todas as categorias cadastradas no sistema.

**Códigos de status**

`200` sucesso

---

`GET` /categoria/{id}

Retorna os detalhes de uma categoria com o `id` informado.

**Códigos de status**

`200` Sucesso

`404` Id não encontrado

---

`POST` /categoria

Cadastrar uma nova categoria.

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|----------
| nome | string|    ✅    | Um nome curto para identificar a categoria
| icone | string |    ❌   | O nome do ícone conforme biblioteca material design 

**Códigos de status**

`201` Criado com sucesso

`400` Validação falhou

---

`DELETE` /categoria/{id}

Apaga a categoria com o `id` informado.

**Códigos de status**

`204` Apagado com sucesso

`404` id não encontrado

---

`PUT` /categoria/{id}

Altera a categoria com o `id` informado.

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|----------
| nome | string|    ✅    | Novo nome curto para identificar a categoria
| icone | string |    ✅  | Novo nome do ícone conforme biblioteca material design 

**Códigos de status**

`200` Sucesso

`404` id não encontrado

`400` Validação falhou

---

**Schema** 
```js
{
  "id": 1
  "nome": "Alimentação",
  "icone":"fast-food"
}

```

