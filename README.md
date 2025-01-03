# **Work Order Management System**

## **Overview**
The **Work Order Management System** is designed to help manage work orders, customer data, and purchase records for a painting business. This system streamlines tracking and querying essential business information, such as customer work orders, material purchases, and project details.

## **Features**
### Minimum Viable Product (MVP)
- Store and manage **customer information**.
- Record and organize **work orders** with detailed descriptions and goals.
- Track **purchases** linked to specific work orders.
- Maintain itemized purchase details, including materials, quantities, and costs.

### Planned Features
- Add a **GUI interface** for user-friendly interactions.
- Integrate the system with external software or a company website.
- Automate data entry through receipt uploads and document parsing.
- Generate **reports** summarizing costs, work orders, and customer details.
- Implement **advanced querying** to analyze data trends.

---

## **Data Entry Workflow**
### Current Process
The system currently supports **manual data entry** for:
- **Work Orders**: Enter details such as work order number, customer information, project manager, and notes via the GUI or CLI.
- **Receipts**: Input supplier, purchase date, job name, and itemized details manually.

### Future Enhancements
To improve efficiency and usability, the system will evolve to include **automated data entry**:
1. **Receipt Automation**:
   - Users will upload photos of receipts.
   - The system will use Optical Character Recognition (OCR) to extract and pre-fill receipt data.
   - Users can review and confirm extracted details before saving.

2. **Work Order Automation**:
   - Upload screenshots, photos, or Word documents of work orders.
   - The system will parse the documents to extract relevant fields automatically.
   - Users can edit and finalize the data.

3. **Flexibility**:
   - Manual entry will always remain an option for edge cases or corrections.

---

## **Technologies Used**
- **Programming Language**: Java
- **Database**: MySQL
- **Build Tool**: Gradle
- **Version Control**: Git and GitHub

---

## **How to Run**
1. Clone this repository to your local machine:
   ```bash
   git clone <repository-link>