function getAllProduct() {
    getAllCategory1()
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/employee",
        success: function (employees) {
            let content = '<table class="table table" border="1"><tr>\n' +
                '        <th>Name</th>\n' +
                '        <th>Code</th>\n' +
                '        <th>Age</th>\n' +
                '        <th>Salary</th>\n' +
                '        <th>Department</th>\n' +
                '        <th colspan="2">Action</th>\n' +
                '    </tr>';
            for (let i = 0; i < employees.length; i++) {
                content += displayProduct(employees[i]);
            }
            content += '</table>'
            document.getElementById('list_product').innerHTML = content;
        }
    });
    document.getElementById("backAll").hidden = true

}



function getAllProductAge() {
    document.getElementById("backAll").hidden = false
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/employee/sort",
        success: function (employees) {
            let content = '<table class="table table" border="1"><tr>\n' +
                '        <th>Name</th>\n' +
                '        <th>Code</th>\n' +
                '        <th>Age</th>\n' +
                '        <th>Salary</th>\n' +
                '        <th>Department</th>\n' +
                '        <th colspan="2">Action</th>\n' +
                '    </tr>';
            for (let i = 0; i < employees.length; i++) {
                content += displayProduct(employees[i]);
            }
            content += '</table>'
            document.getElementById('list_product').innerHTML = content;
        }
    });
}



function getAllProductDepartment() {
    document.getElementById("backAll").hidden = false
    let idDepartment = $("#categories").val();
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/employee/sortEmployeeByDepartment/" + idDepartment,
        success: function (employees) {
            let content = '<table class="table table" border="1"><tr>\n' +
                '        <th>Name</th>\n' +
                '        <th>Code</th>\n' +
                '        <th>Age</th>\n' +
                '        <th>Salary</th>\n' +
                '        <th>Department</th>\n' +
                '        <th colspan="2">Action</th>\n' +
                '    </tr>';
            for (let i = 0; i < employees.length; i++) {
                content += displayProduct(employees[i]);
            }
            content += '</table>'
            document.getElementById('list_product').innerHTML = content;
        }
    });
}





function displayProduct(employee) {
    return `<tr>
                <td > <p onclick="detailProduct(${employee.id})">  ${employee.name}</p></td>
                <td >${employee.code}</td>
                <td >${employee.age}</td>
                <td >${employee.salary}</td>
                <td >${employee.department.name}</td>
          
        <td><button  class="btn btn-danger" onclick="deleteProduct(${employee.id})" >Delete</button>
        <button  type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="updateProduct(${employee.id});" data-bs-whatever="@mdo" ">Update</button></td>
        </tr>`;
}



function getAllCategory() {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/department",
        success: function (departments) {

            let content = `<select onchange="getAllProductDepartment()" class="form-select" id="categories">`
            for (let i = 0; i < departments.length; i++) {
                content += disPlayCategory(departments[i]);
            }
            content += '</select>';
            document.getElementById('category-create').innerHTML = content

        }
    });
}


function getAllCategory1() {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/department",
        success: function (departments) {

            let content = `<select onchange="getAllProductDepartment()" class="form-select" id="categories">`
            for (let i = 0; i < departments.length; i++) {
                content += disPlayCategory(departments[i]);
            }
            content += '</select>';
            document.getElementById('category-create1').innerHTML = content

        }
    });
}


function create(){
   window.location.href = "create.html"
}

function disPlayCategory(department){
      return`<option value="${department.id}">${department.name}</option>`

}

let idUpdate;
let employeeUpdate
function updateProduct(id) {


    idUpdate = id
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/employee/" + id,
        success: function (data) {
            window.localStorage.setItem("employee",JSON.stringify(data))
            window.location.href="edit.html"
        }
    });

}


function detailProduct(id) {
    // document.getElementById('btn-create').hidden = true;
    // document.getElementById('btn-edit').hidden = false;

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/employee/" + id,
        success: function (data) {
            window.localStorage.setItem("employee",JSON.stringify(data))
            window.location.href="detail.html"
        }
    });

}


function getData(){
    employeeUpdate = JSON.parse(window.localStorage.getItem("employee"))
    $("#name").val(employeeUpdate.name);
    $("#code").val(employeeUpdate.code);
    $("#age").val(employeeUpdate.age);
    $("#salary").val(employeeUpdate.salary);
    $("#categories").val(employeeUpdate.department.id);
    $("#department").val(employeeUpdate.department.name);
}



function update() {
    let name = $("#name").val()
    let code = $("#code").val()
    let age = $("#age").val()
    let salary = $("#salary").val()
    let department = $("#categories").val()
    let newProduct = {
        name: name,
        code: code,
        age: age,
        salary:salary,
        department:{
            id: department
        }
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        url: "http://localhost:8080/employee/" + employeeUpdate.id,
        data: JSON.stringify(newProduct),
        success: function () {
                alert("Sua thanh cong")
        }
    })
    event.preventDefault();
}


function deleteProduct(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire(
                'Deleted!',
                'Your file has been deleted.',
                'success'
            )
            $.ajax({
                type: "DELETE",
                url: "http://localhost:8080/employee/" + id,
                success: function () {
                    getAllProduct()
                }
            });
        }
    })


}

function createProduct() {
    let name = $("#name").val()
    let code = $("#code").val()
    let age = $("#age").val()
    let salary = $("#salary").val()
    let department = $("#categories").val()
    let newProduct = {
        name: name,
        code: code,
        age: age,
        salary:salary,
        department:{
          id: department
        }
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/employee",
        data: JSON.stringify(newProduct),
        success: function (data) {
            getAllProduct()
            if (data.name != null) {
                alert("Tạo thành công!")
            }
            $("#exampleModal").modal('hide')
        }
    })
    event.preventDefault();
}

