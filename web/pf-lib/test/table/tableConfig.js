export const tableConfigA = {
  columns:[
    {data:"id", title:"ID"},
    {data:"fname", title:"First Name"},
    {data:"lname", title:"Last Name"}],
  data: [
    {id: "1", fname: "John", lname: "Smith"},
    {id: "2", fname: "Jacob", lname: "Jones"},
    {id: "3", fname: "David", lname: "Taylor"},
    {id: "4", fname: "Michael", lname: "Johnson"},
    {id: "5", fname: "Richard", lname: "Jackson"},
    {id: "6", fname: "Josh", lname: "Shaw"},
    {id: "7", fname: "Christian", lname: "Lloyd"},
    {id: "8", fname: "Lukas", lname: "Ellis"},
    {id: "9", fname: "Lindsay", lname: "Martin"},
    {id: "10", fname: "Daniel", lname: "Johnston"},
    {id: "12", fname: "Jerry", lname: "Carr"},
    {id: "13", fname: "Ian", lname: "Hamilton"},
    {id: "14", fname: "Warren", lname: "Cox"},
    {id: "15", fname: "Peter", lname: "Foster"},
    {id: "16", fname: "Alex", lname: "Barnes"},
    {id: "17", fname: "Cody", lname: "Gordon"}
  ],
  dom: "t",
  order: [[ 0, 'asc' ]],
  pfConfig: {
    filterCaseInsensitive: true,
    paginationSelector: "#pagination1",
    colvisMenuSelector: '.table-view-pf-colvis-menu'
  },
};


export const tableConfigB = {
  columns:[
    {data:"id", title:"ID"},
    {data:"fname", title:"First Name"},
    {data:"lname", title:"Last Name"}],
  data: [
    {id: "1", fname: "John", lname: "Smith"},
    {id: "2", fname: "Jacob", lname: "Jones"},
    {id: "3", fname: "David", lname: "Taylor"},
    {id: "4", fname: "Michael", lname: "Johnson"},
    {id: "5", fname: "Richard", lname: "Jackson"},
    {id: "6", fname: "Josh", lname: "Shaw"},
    {id: "7", fname: "Christian", lname: "Lloyd"},
    {id: "8", fname: "Lukas", lname: "Ellis"},
    {id: "9", fname: "Lindsay", lname: "Martin"},
  ],
  dom: "t",
  order: [[ 0, 'asc' ]],
  pfConfig: {
    filterCaseInsensitive: true,
    paginationSelector: "#pagination1",
    colvisMenuSelector: '.table-view-pf-colvis-menu'
  },
};
